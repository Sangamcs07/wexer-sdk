package com.dmi.mykotlinlib.networking

import android.os.Build
import com.dmi.mykotlinlib.R
import com.dmi.mykotlinlib.pref.PrefKeys
import com.dmi.mykotlinlib.pref.SdkPref
import com.dmi.mykotlinlib.start.SdkInit
import com.dmi.mykotlinlib.start.WCSDKConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CommonInterceptor(private val authorization: Int = 0) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(getBasicHeader(chain.request()))
    }

    private fun getBasicHeader(requ: Request): Request {
        if (!SdkInit.isSdkInitialised())
            return requ

        var request = requ

        val config = SdkInit.getConfig()

        val tenantId: String = config.tenantId

        var versionName: String = config.appName + "/"
        versionName += config.context.packageManager.getPackageInfo(
            config.context.packageName,
            0
        ).versionName


        var requestBuilder = request.newBuilder()

        requestBuilder
            .addHeader("User-Agent", versionName + "(Android " + Build.VERSION.RELEASE + ")")
            .addHeader(config.context.getString(R.string.KEY_TENANT_ID), tenantId)

        if (authorization == 1) {
            requestBuilder.addHeader(
                "Authorization",
                "Bearer " + SdkPref.getStringValue(PrefKeys.user_token)
            )
        } else {
            requestBuilder.addHeader(
                "Authorization",
                "Basic " + getApiAuthenticationHash(config)
            )
        }

        return requestBuilder.build()
    }

    private fun getApiAuthenticationHash(config: WCSDKConfig): String {
        val combined: String = config.clientId + ":" + config.secrete

        val encodedStr =
            String(android.util.Base64.encode(combined.toByteArray(), android.util.Base64.NO_WRAP))

        return encodedStr;
    }
}
package com.dmi.mykotlinlib.start

import android.text.TextUtils
import com.dmi.mykotlinlib.R
import com.dmi.mykotlinlib.exceptionhandle.WexerSdkException
import com.dmi.mykotlinlib.sdklogger.WexerSdkLogger
import org.jetbrains.annotations.NotNull

object SdkInit : ISdkInit {
    private lateinit var mWCSDKConfig: WCSDKConfig

    @Throws(WexerSdkException::class)
    override fun init(@NotNull mWCSDKConfig: WCSDKConfig) {

        if (TextUtils.isEmpty(mWCSDKConfig.appName)) {
            throw WexerSdkException(mWCSDKConfig.context.getString(R.string.wexer_ept_app_name))
        }

        if (TextUtils.isEmpty(mWCSDKConfig.baseUrl)) {
            WexerSdkLogger.print(mWCSDKConfig.context.getString(R.string.wexer_ept_base_url))
            throw WexerSdkException(mWCSDKConfig.context.getString(R.string.wexer_ept_base_url))
        }

        if (TextUtils.isEmpty(mWCSDKConfig.clientId)) {
            WexerSdkLogger.print(mWCSDKConfig.context.getString(R.string.wexer_ept_client_id))
            throw WexerSdkException(mWCSDKConfig.context.getString(R.string.wexer_ept_client_id))
        }

        if (TextUtils.isEmpty(mWCSDKConfig.secrete)) {
            WexerSdkLogger.print(mWCSDKConfig.context.getString(R.string.wexer_ept_secret))
            throw WexerSdkException(mWCSDKConfig.context.getString(R.string.wexer_ept_secret))
        }

        if (TextUtils.isEmpty(mWCSDKConfig.tenantId)) {
            WexerSdkLogger.print(mWCSDKConfig.context.getString(R.string.wexer_ept_tenant_id))
            throw WexerSdkException(mWCSDKConfig.context.getString(R.string.wexer_ept_tenant_id))
        }

        if (TextUtils.isEmpty(mWCSDKConfig.localyticsKey)) {
            WexerSdkLogger.print(mWCSDKConfig.context.getString(R.string.wexer_ept_localytics_key))
            throw WexerSdkException(mWCSDKConfig.context.getString(R.string.wexer_ept_localytics_key))
        }

        /*Now start SDK init from here*/
        sdkInit(mWCSDKConfig)
    }

    override fun isSdkInitialised(): Boolean {
        return SdkInit::mWCSDKConfig.isInitialized
    }

    override fun getConfig(): WCSDKConfig {
        return mWCSDKConfig
    }

    private fun sdkInit(mWCSDKConfig: WCSDKConfig) {
        // start sdk background processing
        this.mWCSDKConfig = mWCSDKConfig
    }
}
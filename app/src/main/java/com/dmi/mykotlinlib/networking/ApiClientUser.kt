package com.dmi.mykotlinlib.networking

import com.dmi.mykotlinlib.start.SdkInit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClientUser : BaseApiClient() {

    private val okHttpClient by lazy {
        baseOkHttpClient.newBuilder()
            .connectTimeout(NetworkTime.DEFAULT_CONNECT_TIMEOUT_IN_MIN, TimeUnit.MINUTES)
            .writeTimeout(NetworkTime.DEFAULT_WRITE_TIMEOUT_IN_MIN, TimeUnit.MINUTES)
            .readTimeout(NetworkTime.DEFAULT_READ_TIMEOUT_IN_MIN, TimeUnit.MINUTES)
            .addInterceptor(CommonInterceptor(1)).build()
    }

    val instance: APIs by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(SdkInit.getConfig().baseUrl)
            .addConverterFactory(gsonFactory)
            .client(okHttpClient)
            .build()

        retrofit.create(APIs::class.java)
    }

}
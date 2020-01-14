package com.dmi.mykotlinlib.networking

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseApiClient {

    protected val gsonFactory = GsonConverterFactory.create()

    protected val baseOkHttpClient = OkHttpClient()

    protected fun resetHttpClient() {
        baseOkHttpClient.dispatcher().cancelAll()
        /*baseOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(NetworkTime.DEFAULT_CONNECT_TIMEOUT_IN_MIN, TimeUnit.MINUTES)
            .writeTimeout(NetworkTime.DEFAULT_WRITE_TIMEOUT_IN_MIN, TimeUnit.MINUTES)
            .readTimeout(NetworkTime.DEFAULT_READ_TIMEOUT_IN_MIN, TimeUnit.MINUTES)
            .addInterceptor(CommonInterceptor()).build()*/
    }

    protected fun cancelAllRequest() {
        baseOkHttpClient.dispatcher().cancelAll()
    }
}
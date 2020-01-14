package com.dmi.mykotlinlib.start

import android.content.Context
import androidx.annotation.Keep

@Keep
data class WCSDKConfig(
    var context: Context,
    val appName: String,
    val baseUrl: String,
    val clientId: String,
    val secrete: String,
    val tenantId: String,
    val localyticsKey: String
) {
    init {
        context = context.applicationContext
    }
}
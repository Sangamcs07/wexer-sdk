package com.dmi.mykotlinlib.networking

import androidx.annotation.Keep

@Keep
data class BodyUser(
    val username: String,
    val password: String,
    val consentRequest: String = "",
    val skipconsent: Boolean,
    val firstname: String = "",
    val lastname: String = ""
)
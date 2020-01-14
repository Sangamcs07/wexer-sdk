package com.dmi.mykotlinlib.pojo

import androidx.annotation.Keep

@Keep
data class User(
    val Username: String,
    val UserId: String,
    val Code: String
)
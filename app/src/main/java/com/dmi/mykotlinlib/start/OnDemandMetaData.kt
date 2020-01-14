package com.dmi.mykotlinlib.start

import androidx.annotation.Keep

@Keep
data class OnDemandMetaData(
    val equipments: String,
    val classTypes: String,
    val providers: String,
    val language: String,
    val duration: String,
    val intensity: String,
    val take: String = "",
    val skip: String = ""
)
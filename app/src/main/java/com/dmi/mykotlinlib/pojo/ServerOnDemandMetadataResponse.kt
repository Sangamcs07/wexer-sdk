package com.dmi.mykotlinlib.pojo

import androidx.annotation.Keep

@Keep
data class ServerOnDemandMetadataResponse(
    val equipments: List<KeyValue>,
    val classTypes: List<String>,
    val providers: List<String>,
    val language: List<KeyValue>,
    val duration: DurationKeyValue,
    val intensity: DurationKeyValue
)

@Keep
data class KeyValue(
    val value: String,
    val text: String
)

@Keep
data class DurationKeyValue(
    val min: String,
    val max: String
)
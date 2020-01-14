package com.dmi.mykotlinlib.pojo

import androidx.annotation.Keep

@Keep
data class TenantCollection(
    val CollectionType: String,
    val CollectionName: String,
    val CollectionTag: String,
    val ItemCount: Int,
    val CollectionItems: List<String>
)
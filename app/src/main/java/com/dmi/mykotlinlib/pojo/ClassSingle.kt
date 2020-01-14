package com.dmi.mykotlinlib.pojo

import androidx.annotation.Keep

@Keep
data class ClassSingle(
    val tag: String,
    val className: String,
    val classDescription: String,
    val classCategories: String,
    val languageName: String,
    val providerID: String,
    val provider: String,
    val instructor: String,
    val imageLink: String,
    val streamingLink: String,
    val classCategory: List<String>,
    val intensity: Int,
    val skill: Int,
    val calorieBurn: Int,
    val durationSecond: Int,
    val durationMinutes: String,
    val equipmentNames: List<String>,
    val equipmentTypes: Boolean,
    val isActive: Boolean,
    val keywords: String,
    val creationDate: String,
    val lastModifiedDate: String,
    val favourite: Boolean,
    val alternateLink: String,
    val trailerLinkWeb: String,
    val trailerLinkMobile: String,
    val trailerName: String
)
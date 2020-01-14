package com.dmi.mykotlinlib.networking

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ConsentURLModel(var linkText: String, var linkUrl: String) : Parcelable
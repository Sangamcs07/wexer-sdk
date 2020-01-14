package com.dmi.mykotlinlib.pojo

import android.os.Parcel
import android.os.Parcelable
import com.dmi.mykotlinlib.networking.ConsentURLModel
import kotlinx.android.parcel.Parcelize
import java.util.ArrayList

@Parcelize
data class Consent(
    val consentTag: String,
    val policy: String,
    val title: String,
    val version: String,
    val publishedDate: String,
    val isMandatory: Boolean,
    val urls: ArrayList<ConsentURLModel>
) : Parcelable
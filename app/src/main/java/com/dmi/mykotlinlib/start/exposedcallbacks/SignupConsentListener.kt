package com.dmi.mykotlinlib.start.exposedcallbacks

import androidx.annotation.Keep
import com.dmi.mykotlinlib.pojo.Consent

@Keep
interface SignupConsentListener : MarkerListener {
    fun onSuccess(response: String, tenantCollection: List<Consent>?)
}
package com.dmi.mykotlinlib.start.exposedcallbacks

import androidx.annotation.Keep
import com.dmi.mykotlinlib.pojo.ServerOnDemandMetadataResponse

@Keep
interface OnDemandMetadataListener : MarkerListener {
    fun onSuccess(response: String, tenantCollection: ServerOnDemandMetadataResponse?)
}
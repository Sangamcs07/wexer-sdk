package com.dmi.mykotlinlib.start.exposedcallbacks

import androidx.annotation.Keep
import com.dmi.mykotlinlib.pojo.TenantCollection

@Keep
interface TenantCollectionListener : MarkerListener {
    fun onSuccess(response: String, tenantCollection: List<TenantCollection>?)
}
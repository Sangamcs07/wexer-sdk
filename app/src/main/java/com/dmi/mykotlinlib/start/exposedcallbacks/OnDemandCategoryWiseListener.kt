package com.dmi.mykotlinlib.start.exposedcallbacks

import androidx.annotation.Keep
import com.dmi.mykotlinlib.pojo.ClassSingle

@Keep
interface OnDemandCategoryWiseListener : MarkerListener {
    fun onSuccess(response: String, tenantCollection: List<ClassSingle>?)
}
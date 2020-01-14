package com.dmi.mykotlinlib.start.exposedcallbacks

import androidx.annotation.Keep
import com.dmi.mykotlinlib.pojo.ClassSingle

@Keep
interface SingleClassDataListener : MarkerListener {
    fun onSuccess(response: String, tenantCollection: List<ClassSingle>?)
}
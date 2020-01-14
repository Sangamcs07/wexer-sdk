package com.dmi.mykotlinlib.start.exposedcallbacks

import androidx.annotation.Keep

@Keep
interface MarkerListener {
    fun onError(result: String)
}
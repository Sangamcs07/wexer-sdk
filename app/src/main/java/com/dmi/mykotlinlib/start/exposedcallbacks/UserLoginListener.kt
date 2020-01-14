package com.dmi.mykotlinlib.start.exposedcallbacks

import androidx.annotation.Keep
import com.dmi.mykotlinlib.pojo.User

@Keep
interface UserLoginListener : MarkerListener {
    fun onSuccess(response: String, user: User?)
}
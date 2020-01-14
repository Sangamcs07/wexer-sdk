package com.dmi.mykotlinlib.sdklogger

import android.content.Context
import android.util.Log
import com.dmi.mykotlinlib.pref.PrefKeys
import com.dmi.mykotlinlib.pref.SdkPref

object WexerSdkLogger {
    private val TAG: String = "WexerContentSdk : "

    fun print(msg: String) {
        if (SdkPref.getBooleanValue(PrefKeys.IsDebugLogOn)!!) {
            Log.e("$TAG", "$msg")
        }
    }

    fun write(context: Context, msg: String) {
        if (SdkPref.getBooleanValue(PrefKeys.IsDebugLogOn)!!) {
            print(msg)
        }
    }
}
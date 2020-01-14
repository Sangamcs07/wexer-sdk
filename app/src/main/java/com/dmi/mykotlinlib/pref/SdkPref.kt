package com.dmi.mykotlinlib.pref

import android.content.Context
import android.content.SharedPreferences
import com.dmi.mykotlinlib.start.SdkInit

object SdkPref {
    private var preferences: SharedPreferences?
    private const val PrefName = "wexer_sdk_pref"

    init {
        preferences = SdkInit.getConfig().context.getSharedPreferences(
            PrefName, Context.MODE_PRIVATE
        )
    }

    fun getStringValue(key: String): String? {
        return preferences?.getString(key, "")
    }

    fun setStringValue(key: String, value: String?) {
        var editor = preferences?.edit()
        editor?.putString(key, value)
        editor?.apply()
    }

    fun getBooleanValue(key: String): Boolean? {
        return preferences?.getBoolean(key, false)
    }

    fun setBooleanValue(key: String, value: Boolean) {
        var editor = preferences?.edit()
        editor?.putBoolean(key, value)
        editor?.apply()
    }

    fun getIntValue(key: String): Int? {
        return preferences?.getInt(key, -1)
    }

    fun setIntValue(key: String, value: Int) {
        var editor = preferences?.edit()
        editor?.putInt(key, value)
        editor?.apply()
    }
}
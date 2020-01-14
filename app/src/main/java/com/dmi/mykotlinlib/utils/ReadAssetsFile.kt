package com.dmi.mykotlinlib.utils

import android.content.Context
import com.dmi.mykotlinlib.start.SdkInit

object ReadAssetsFile {
    fun readFile(fileName: String): String {
        val json_string = SdkInit.getConfig().context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        return json_string
    }

    fun readFile(context: Context, fileName: String): String {
        val json_string = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        return json_string
    }
}
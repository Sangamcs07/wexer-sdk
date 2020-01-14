package com.dmi.mykotlinlib.start

import android.os.Build
import androidx.annotation.Keep
import com.dmi.mykotlinlib.exceptionhandle.WexerSdkException
import com.dmi.mykotlinlib.start.startup.SdkInstance
import org.jetbrains.annotations.NotNull

@Keep
object WexerContentSDK {

    @Throws(WexerSdkException::class)
    @JvmStatic
    fun init(@NotNull mWCSDKConfig: WCSDKConfig) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            SdkInit.init(mWCSDKConfig)
        else
            throw WexerSdkException("SDK support Android API level 21 and above only")
    }

    @Throws(WexerSdkException::class)
    @JvmStatic
    fun getInstance(): ISdkInstance {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return SdkInstance()
        else
            throw WexerSdkException("SDK support Android API level 21 and above only")
    }

    /*@Throws(WexerSdkException::class)
    @JvmStatic
    fun getData(): ISdkGet {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return SdkGet()
        else
            throw WexerSdkException("SDK support Android API level 21 and above only")
    }

    @Throws(WexerSdkException::class)
    @JvmStatic
    fun updateData(): ISdkUpdate {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return SdkUpdate()
        else
            throw WexerSdkException("SDK support Android API level 21 and above only")
    }*/
}
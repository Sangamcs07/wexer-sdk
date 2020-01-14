package com.dmi.mykotlinlib.start

import org.jetbrains.annotations.NotNull

interface ISdkInit {
    fun init(@NotNull mWCSDKConfig: WCSDKConfig)
    fun isSdkInitialised(): Boolean
    fun getConfig(): WCSDKConfig
}
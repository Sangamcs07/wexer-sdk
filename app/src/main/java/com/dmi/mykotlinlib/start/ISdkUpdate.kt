package com.dmi.mykotlinlib.start

import com.dmi.mykotlinlib.networking.BodyUser

interface ISdkUpdate {
    fun disableBackendApi()
    fun submitOndemandActivity()
    fun submitLocalLytics()
    fun submitVideoPlayerStarted()

    fun submitVideoPlayerClosed()
    fun setDebuggerLog()
}
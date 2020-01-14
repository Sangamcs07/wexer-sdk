package com.dmi.mykotlinlib.start

interface ISdkGet {
    fun getSignUpConsent()
    fun getUserConsent()
    fun fetchOnDemand()
    fun fetchOnDemandCollection()
    fun fetchTenantCollection()
    fun fetchOndemandSearch()
    fun fetchContentFiltered()
    fun playVideo()
    fun getVideoUrlFromTag()
    fun getSessionId()
}
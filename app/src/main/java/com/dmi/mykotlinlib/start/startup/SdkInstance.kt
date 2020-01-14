package com.dmi.mykotlinlib.start.startup

import com.dmi.mykotlinlib.exceptionhandle.WexerSdkException
import com.dmi.mykotlinlib.networking.BodyUser
import com.dmi.mykotlinlib.pref.PrefKeys
import com.dmi.mykotlinlib.pref.SdkPref
import com.dmi.mykotlinlib.start.ISdkInstance
import com.dmi.mykotlinlib.start.SdkInit
import com.dmi.mykotlinlib.repositories.SdkRepository
import com.dmi.mykotlinlib.start.exposedcallbacks.*

class SdkInstance : ISdkInstance {

    init {
        if (!SdkInit.isSdkInitialised())
            throw WexerSdkException("SDK Config is not initialised yet")
    }

    override fun enableDebugLog(enabled: Boolean) {
        SdkPref.setBooleanValue(PrefKeys.IsDebugLogOn, enabled)
    }

    override fun createUser(user: BodyUser, mUserLoginListener: UserLoginListener?) {
        SdkRepository.createUser(user, mUserLoginListener)
    }

    override fun fetchTenantCollection(mTenantCollectionListener: TenantCollectionListener?) {
        SdkRepository.fetchTenantCollection(mTenantCollectionListener)
    }

    override fun fetchOnDemandCategoryWise(
        categoryTag: String,
        mOnDemandCategoryWiseListener: OnDemandCategoryWiseListener?
    ) {
        SdkRepository.fetchOnDemandCategoryWise(categoryTag, mOnDemandCategoryWiseListener)
    }

    override fun fetchSingleClassData(
        classTag: String,
        mSingleClassDataListener: SingleClassDataListener?
    ) {
        SdkRepository.fetchSingleClassData(classTag, mSingleClassDataListener)
    }

    override fun fetchAllClassData(
        mSingleClassDataListener: SingleClassDataListener?
    ) {
        SdkRepository.fetchAllClassData(mSingleClassDataListener)
    }

    override fun fetchOnDemandMetadata(mOnDemandMetadataListener: OnDemandMetadataListener?) {
        SdkRepository.fetchOnDemandMetadata(mOnDemandMetadataListener)
    }
}
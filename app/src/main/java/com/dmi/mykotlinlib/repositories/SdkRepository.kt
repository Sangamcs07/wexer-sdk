package com.dmi.mykotlinlib.repositories

import com.dmi.mykotlinlib.networking.BodyUser
import com.dmi.mykotlinlib.start.exposedcallbacks.*

internal object SdkRepository {
    //private lateinit var localDataSource: LocalDataSource
    private val remoteDataSource: RemoteDataSource

    init {
        remoteDataSource =
            RemoteDataSource()
    }

    fun getSignUpConsent(mSdkGetListener: SignupConsentListener?) {
        remoteDataSource.getSignUpConsent(mSdkGetListener)
    }

    fun fetchTenantCollection(
        mTenantCollectionListener: TenantCollectionListener?
    ) {
        remoteDataSource.fetchTenantCollection(mTenantCollectionListener)
    }

    fun fetchOnDemandCategoryWise(
        categoryTag: String,
        mOnDemandCategoryWiseListener: OnDemandCategoryWiseListener?
    ) {
        remoteDataSource.fetchOnDemandCategoryWise(categoryTag, mOnDemandCategoryWiseListener)
    }

    fun fetchSingleClassData(
        categoryTag: String,
        mSingleClassDataListener: SingleClassDataListener?
    ) {
        remoteDataSource.fetchSingleClassData(categoryTag, mSingleClassDataListener)
    }

    fun fetchAllClassData(
        mSingleClassDataListener: SingleClassDataListener?
    ) {
        remoteDataSource.fetchAllClassData(mSingleClassDataListener)
    }

    fun fetchOnDemandMetadata(
        mOnDemandMetadataListener: OnDemandMetadataListener?
    ) {
        remoteDataSource.fetchOnDemandMetadata(mOnDemandMetadataListener)
    }

    fun createUser(user: BodyUser, mUserLoginListener: UserLoginListener?) {
        remoteDataSource.createUser(user, mUserLoginListener)
    }
}
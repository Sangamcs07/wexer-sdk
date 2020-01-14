package com.dmi.mykotlinlib.start

import androidx.annotation.Keep
import com.dmi.mykotlinlib.networking.BodyUser
import com.dmi.mykotlinlib.start.exposedcallbacks.*

@Keep
interface ISdkInstance {
    fun enableDebugLog(enabled: Boolean)
    fun createUser(user: BodyUser, mUserLoginListener: UserLoginListener?)
    fun fetchTenantCollection(mTenantCollectionListener: TenantCollectionListener?)
    fun fetchOnDemandCategoryWise(
        categoryTag: String,
        mOnDemandCategoryWiseListener: OnDemandCategoryWiseListener?
    )

    fun fetchSingleClassData(
        classTag: String,
        mSingleClassDataListener: SingleClassDataListener?
    )

    fun fetchAllClassData(
        mSingleClassDataListener: SingleClassDataListener?
    )

    fun fetchOnDemandMetadata(
        mOnDemandMetadataListener: OnDemandMetadataListener?
    )
}
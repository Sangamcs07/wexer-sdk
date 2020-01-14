package com.dmi.mykotlinlib.networking

import com.dmi.mykotlinlib.pojo.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIs {

    @GET("/api/v2/consent/")
    fun fetchSignUpConsent(): Call<List<Consent>>

    @POST("/oauth/sdk/login/")
    fun createUser(@Body body: RequestBody): Call<User>

    @GET("/sdk/v1/collections/")
    fun fetchTenantCollection(): Call<List<TenantCollection>>

    @GET("/sdk/v1/perform/{catTag}")
    fun fetchOnDemandCategoryWise(
        @Path(
            value = "catTag",
            encoded = true
        ) categoryTag: String
    ): Call<List<ClassSingle>>

    // if classId is empty then will fetch all class datas else fetch respective class data
    @GET("/sdk/v1/classes/{classId}")
    fun fetchClassData(
        @Path(
            value = "classId",
            encoded = true
        ) categoryTag: String
    ): Call<List<ClassSingle>>

    @GET("/api/v1/users/ondemand/metadata")
    fun fetchOnDemandMetadata(): Call<ServerOnDemandMetadataResponse>
}
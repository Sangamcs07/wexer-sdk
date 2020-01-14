package com.dmi.mykotlinlib.repositories

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.dmi.mykotlinlib.networking.ApiClient
import com.dmi.mykotlinlib.networking.ApiClientUser
import com.dmi.mykotlinlib.networking.BodyUser
import com.dmi.mykotlinlib.networking.NetworkUtils
import com.dmi.mykotlinlib.pojo.*
import com.dmi.mykotlinlib.start.SdkInit
import com.dmi.mykotlinlib.start.exposedcallbacks.*
import com.dmi.mykotlinlib.vplayer.WexerVidPlayerActivity
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

internal class RemoteDataSource {

    fun playVideo() {
        val intent = Intent(SdkInit.getConfig().context, WexerVidPlayerActivity::class.java)
        // start your next activity

        // intent.putExtra("url", mSdkRequester.sessionID)
        startActivity(SdkInit.getConfig().context, intent, null)
    }

    fun getSignUpConsent(mSdkGetListener: SignupConsentListener?) {

        ApiClient.instance.fetchSignUpConsent().enqueue(
            object : Callback<List<Consent>> {
                override fun onFailure(call: Call<List<Consent>>, t: Throwable) {
                    NetworkUtils.handleFailure(t, mSdkGetListener as MarkerListener)
                }

                override fun onResponse(
                    call: Call<List<Consent>>,
                    response: Response<List<Consent>>
                ) {
                    NetworkUtils.handleSuccess(response, mSdkGetListener as MarkerListener)
                }
            }
        )
    }

    fun fetchTenantCollection(mTenantCollectionListener: TenantCollectionListener?) {
        ApiClientUser.instance.fetchTenantCollection()
            .enqueue(object : Callback<List<TenantCollection>> {
                override fun onFailure(call: Call<List<TenantCollection>>, t: Throwable) {
                    NetworkUtils.handleFailure(t, mTenantCollectionListener as MarkerListener)
                }

                override fun onResponse(
                    call: Call<List<TenantCollection>>,
                    response: Response<List<TenantCollection>>
                ) {
                    NetworkUtils.handleSuccess(
                        response,
                        mTenantCollectionListener as MarkerListener
                    )
                }

            })
    }

    fun fetchOnDemandCategoryWise(
        categoryTag: String,
        mOnDemandCategoryWiseListener: OnDemandCategoryWiseListener?
    ) {
        ApiClientUser.instance.fetchOnDemandCategoryWise(categoryTag)
            .enqueue(object : Callback<List<ClassSingle>> {
                override fun onFailure(call: Call<List<ClassSingle>>, t: Throwable) {
                    NetworkUtils.handleFailure(t, mOnDemandCategoryWiseListener as MarkerListener)
                }

                override fun onResponse(
                    call: Call<List<ClassSingle>>,
                    response: Response<List<ClassSingle>>
                ) {
                    NetworkUtils.handleSuccess(
                        response,
                        mOnDemandCategoryWiseListener as MarkerListener
                    )
                }

            })
    }

    fun fetchSingleClassData(
        categoryTag: String,
        mSingleClassDataListener: SingleClassDataListener?
    ) {
        ApiClientUser.instance.fetchClassData(categoryTag)
            .enqueue(object : Callback<List<ClassSingle>> {
                override fun onFailure(call: Call<List<ClassSingle>>, t: Throwable) {
                    NetworkUtils.handleFailure(t, mSingleClassDataListener as MarkerListener)
                }

                override fun onResponse(
                    call: Call<List<ClassSingle>>,
                    response: Response<List<ClassSingle>>
                ) {
                    NetworkUtils.handleSuccess(
                        response,
                        mSingleClassDataListener as MarkerListener
                    )
                }

            })
    }

    fun fetchAllClassData(
        mSingleClassDataListener: SingleClassDataListener?
    ) {
        ApiClientUser.instance.fetchClassData("")
            .enqueue(object : Callback<List<ClassSingle>> {
                override fun onFailure(call: Call<List<ClassSingle>>, t: Throwable) {
                    NetworkUtils.handleFailure(t, mSingleClassDataListener as MarkerListener)
                }

                override fun onResponse(
                    call: Call<List<ClassSingle>>,
                    response: Response<List<ClassSingle>>
                ) {
                    NetworkUtils.handleSuccess(
                        response,
                        mSingleClassDataListener as MarkerListener
                    )
                }

            })
    }

    fun fetchOnDemandMetadata(
        mOnDemandMetadataListener: OnDemandMetadataListener?
    ) {
        ApiClientUser.instance.fetchOnDemandMetadata()
            .enqueue(object : Callback<ServerOnDemandMetadataResponse> {
                override fun onFailure(call: Call<ServerOnDemandMetadataResponse>, t: Throwable) {
                    NetworkUtils.handleFailure(t, mOnDemandMetadataListener as MarkerListener)
                }

                override fun onResponse(
                    call: Call<ServerOnDemandMetadataResponse>,
                    response: Response<ServerOnDemandMetadataResponse>
                ) {
                    NetworkUtils.handleSuccess(
                        response,
                        mOnDemandMetadataListener as MarkerListener
                    )
                }

            })
    }

    fun createUser(user: BodyUser, mUserLoginListener: UserLoginListener?) {

        var countryCode = Locale.getDefault().country

        var sckipCon = when (user.skipconsent) {
            true -> "true"
            false -> "false"
        }

        var reqBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("client_id", SdkInit.getConfig().clientId)
            .addFormDataPart("response_type", "token")
            .addFormDataPart("redirect_uri", SdkInit.getConfig().baseUrl)
            .addFormDataPart("scope", "openid")
            .addFormDataPart("tenantId", SdkInit.getConfig().tenantId)
            .addFormDataPart("countrycode", countryCode)
            .addFormDataPart("password", user.password)
            .addFormDataPart("username", user.username)
            .addFormDataPart("firstname", user.firstname)
            .addFormDataPart("lastname", user.lastname)
            .addFormDataPart("consentRequest", user.consentRequest)
            .addFormDataPart("skipconsent", sckipCon)
            .build()

        ApiClient.instance.createUser(reqBody).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                NetworkUtils.handleFailure(t, mUserLoginListener as MarkerListener)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                NetworkUtils.handleSuccess(response, mUserLoginListener as MarkerListener)
            }
        })
    }

}
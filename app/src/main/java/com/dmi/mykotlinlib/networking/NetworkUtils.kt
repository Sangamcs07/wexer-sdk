package com.dmi.mykotlinlib.networking

import com.dmi.mykotlinlib.pojo.*
import com.dmi.mykotlinlib.pref.PrefKeys
import com.dmi.mykotlinlib.pref.SdkPref
import com.dmi.mykotlinlib.sdklogger.WexerSdkLogger
import com.dmi.mykotlinlib.start.exposedcallbacks.*
import retrofit2.Response
import java.io.IOException

object NetworkUtils {
    private val successMsg = "Result Fetch successfully"

    private fun <T> getResponseMessage(response: Response<T>): String {
        return when (response.code()) {
            200 -> {
                // user already exist
                "User already exist"
            }
            201 -> {
                // new user created
                "User created successfully"
            }
            401 -> {
                // new user created
                "User session expired, please call token api"
            }
            404 -> {
                // page not found
                "Page not found"
            }
            else -> {
                "Error code not found"
            }
        }
    }

    fun handleFailure(t: Throwable, error: MarkerListener?) {
        if (t is IOException) {
            error?.onError("No Active internet connection found")
        } else
            error?.onError("Error : ${t.message}")
    }

    fun <T> handleSuccess(response: Response<T>, handler: MarkerListener?) {
        val responseCode = response.code()
        WexerSdkLogger.print("Response code $responseCode")

        when (handler) {
            // handle user signup consent
            is SignupConsentListener -> {
                if (responseCode == 200)
                    handler.onSuccess(successMsg, response.body() as List<Consent>)
                else
                    handler.onError(getResponseMessage(response))
            }
            // handle tenant collection list
            is TenantCollectionListener -> {
                if (responseCode == 200)
                    handler.onSuccess(
                        successMsg,
                        response.body() as List<TenantCollection>
                    )
                else
                    handler.onError(getResponseMessage(response))
            }
            // handle OnDemand category wise list data
            is OnDemandCategoryWiseListener -> {
                if (responseCode == 200)
                    handler.onSuccess(
                        successMsg,
                        response.body() as List<ClassSingle>
                    )
                else
                    handler.onError(getResponseMessage(response))
            }
            // handle single class list data
            is SingleClassDataListener -> {
                if (responseCode == 200)
                    handler.onSuccess(
                        successMsg,
                        response.body() as List<ClassSingle>
                    )
                else
                    handler.onError(getResponseMessage(response))
            }

            // handle single class list data
            is OnDemandMetadataListener -> {
                if (responseCode == 200)
                    handler.onSuccess(
                        successMsg,
                        response.body() as ServerOnDemandMetadataResponse
                    )
                else
                    handler.onError(getResponseMessage(response))
            }
            // handle user login/creation
            is UserLoginListener -> {
                if (responseCode == 200 || responseCode == 201) {

                    val userDetail = response.body() as User

                    SdkPref.setStringValue(PrefKeys.user_name, userDetail.Username)
                    SdkPref.setStringValue(PrefKeys.user_id, userDetail.UserId)
                    SdkPref.setStringValue(PrefKeys.user_token, userDetail.Code)

                    handler.onSuccess(successMsg, userDetail)
                } else
                    handler.onError(getResponseMessage(response))
            }
        }
    }

}
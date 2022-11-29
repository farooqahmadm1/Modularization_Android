package com.farooq.core.domain


import com.farooq.core.utils.Logger
import com.google.android.material.R
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import javax.inject.Inject

class NetworkExceptionHandling @Inject constructor(val logger: Logger) {

    companion object {
        private const val TAG = "NetworkException"
        private const val MESSAGE_KEY = "message"
        private const val ERROR_KEY = "error"
    }

    fun <T> execute(e: Exception): Resource<T> {
        logger.log(e.toString())
        return when (e) {
            is HttpException -> {
                when {
                    e.code() == 401 -> {
                        Resource.Error(UIComponent.Dialog("Session Expired", "your token has been expired please logout"), ErrorType.SESSION_EXPIRED)
                    }
                    else -> getErrorMessage(e.response()?.errorBody())
                }
            }
            is SocketTimeoutException -> {
                Resource.Error(UIComponent.Dialog("Timeout", "Please check your internet connection is down or poor."), ErrorType.TIMEOUT)
            }
            is IOException -> Resource.Error(UIComponent.None("Please check your internet connection"), ErrorType.NETWORK)
            else -> Resource.Error(UIComponent.None("Something went wrong"), ErrorType.UNKNOWN)
        }
    }

    private fun <T> getErrorMessage(responseBody: ResponseBody?): Resource<T> {
        return try {
            val jsonObject = JSONObject(responseBody!!.string())
            val message = when {
                jsonObject.has(MESSAGE_KEY) -> jsonObject.getString(MESSAGE_KEY)
                else -> "Something wrong happened"
            }
            Resource.Error(UIComponent.None(if (message.length > 400) "Please Try Again" else message), ErrorType.NETWORK)
        } catch (e: Exception) {
            Resource.Error(UIComponent.None("Something wrong happened"), ErrorType.NETWORK)
        }
    }
}
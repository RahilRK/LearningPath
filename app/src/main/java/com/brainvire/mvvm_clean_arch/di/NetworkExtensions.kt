package com.brainvire.mvvm_clean_arch.di

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.google.gson.Gson
import retrofit2.HttpException
import java.net.SocketTimeoutException

suspend fun <T : Any> makeAPICall(gson: Gson, call: suspend () -> AppResponse<T>): Resource<AppResponse<T>> {
    try {
        val response = call.invoke()
        when (response.statusCode) {
            in (200..300) -> {
                return Resource.Success(response)
            }

            400, 401, 422, 500 -> {
                return Resource.Error(
                    errorCode = response.statusCode,
                    errorMessage = response.message,
                    errorData = response.errors,
                    messageCode = response.messageCode,
                    responseData = response
                )
            }

            else -> {
                return Resource.Error(
                    errorCode = HttpErrorCode.NOT_DEFINED.code,
                    errorMessage = response.message,
                    errorData = response.errors,
                    messageCode = response.messageCode,
                    responseData = response
                )
            }
        }
    } catch (e: Exception) {
        if (e is HttpException) {
            when (e.code()) {
                400, 401, 422 -> {
                    val response = gson.fromJson<AppResponse<T>>(e.response()?.errorBody()?.string(), AppResponse::class.java)
                    return Resource.Error(
                        errorCode = response.statusCode,
                        errorMessage = response.message,
                        errorData = response.errors,
                        messageCode = response.messageCode,
                        responseData = response
                    )
                }

                500 -> {
                    return Resource.Error(
                        errorCode = HttpErrorCode.NOT_DEFINED.code,
                        errorMessage = e.message,
                        responseData = AppResponse<Any>()
                    )
                }
            }
        } else if (e is SocketTimeoutException) {
            return Resource.Error(
                errorCode = 0,
                errorMessage = "Server Timeout",
                errorData = null,
                messageCode = "Error",
                responseData = null
            )
        }
        return Resource.Error(
            errorCode = HttpErrorCode.NOT_DEFINED.code,
            errorMessage = e.message,
            responseData = AppResponse<Any>()
        )
    }
}
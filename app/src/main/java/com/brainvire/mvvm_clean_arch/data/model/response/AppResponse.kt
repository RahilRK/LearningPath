package com.brainvire.mvvm_clean_arch.data.model.response


import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class AppResponse<out T>(
    @SerializedName("message")
    val message: String? = null, // Login Successfully
    @SerializedName("message_code")
    val messageCode: String? = null, // SUCCESS
    @SerializedName("status")
    val status: Boolean? = null, // true
    @SerializedName("status_code")
    val statusCode: Int? = null, // 200
    @SerializedName("data")
    val data: T? = null, // 200
    @SerializedName("errors")
    val errors: JsonObject? = null // 200
)
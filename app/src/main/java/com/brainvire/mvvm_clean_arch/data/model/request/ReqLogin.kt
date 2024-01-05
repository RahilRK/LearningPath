package com.brainvire.mvvm_clean_arch.data.model.request

import com.google.gson.annotations.SerializedName

data class ReqLogin(
    @SerializedName("role")
    var role: String? = null, //service_provider
    @SerializedName("email")
    var email: String? = null, // shahen.provider@shahenexpress.com
    @SerializedName("password")
    var password: String? = null, // ShahenBv@2023
    @SerializedName("device_token")
    var deviceToken: String? = null,
    @SerializedName("platform")
    var platform: String? = null// android
)
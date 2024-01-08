package com.brainvire.mvvm_clean_arch.data.model.response.my_profile

import com.google.gson.annotations.SerializedName
import com.shahen.provider.core.models.responses.login.User

data class RespMyProfile(
    @SerializedName("user")
    val user: User? = User(),
    @SerializedName("userStatus")
    val userStatus: String? = null // activated
)
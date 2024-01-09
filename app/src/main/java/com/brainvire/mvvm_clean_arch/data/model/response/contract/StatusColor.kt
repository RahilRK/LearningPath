package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class StatusColor(
    @SerializedName("main")
    val main: String? = null, // blue
    @SerializedName("hex")
    val hex: String? = null // #2C72B8
)
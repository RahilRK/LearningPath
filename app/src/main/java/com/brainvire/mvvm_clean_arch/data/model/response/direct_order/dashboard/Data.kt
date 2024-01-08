package com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int? = null, // 3
    @SerializedName("label")
    val label: String? = null, // Waiting for approval
    @SerializedName("key")
    val key: String? = null // waiting_for_approval
)
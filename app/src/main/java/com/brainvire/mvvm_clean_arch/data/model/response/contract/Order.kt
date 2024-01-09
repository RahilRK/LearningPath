package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("weekly")
    val weekly: List<ChartData?>? = null,
    @SerializedName("monthly")
    val monthly: List<ChartData?>? = null,
    @SerializedName("yearly")
    val yearly: List<ChartData?>? = null
)
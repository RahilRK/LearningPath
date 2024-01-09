package com.brainvire.mvvm_clean_arch.data.model.response.dashboard

import com.brainvire.mvvm_clean_arch.data.model.response.contract.Order
import com.google.gson.annotations.SerializedName

data class SalesReport(
    @SerializedName("order_total")
    val orderTotal: Double? = 0.0, // 0
    @SerializedName("order")
    val order: Order? = null
)
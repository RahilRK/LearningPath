package com.brainvire.mvvm_clean_arch.data.model.response.dashboard

import com.google.gson.annotations.SerializedName

data class MainDashboardResponse(
    @SerializedName("new_order_count")
    val newOrderCount: Int? = 0, // 0
    @SerializedName("new_order")
    val newOrder: List<CurrentOrder>? = listOf(),
    @SerializedName("current_order_count")
    val currentOrderCount: Int? = 0, // 4
    @SerializedName("current_order")
    val currentOrder: List<CurrentOrder>? = listOf(),
    @SerializedName("sales_report")
    val salesReport: SalesReport? = SalesReport()
)
package com.brainvire.mvvm_clean_arch.domain.model

import com.brainvire.learning.R

data class DashboardOrders(
    val icon: Int = R.drawable.ic_direct_orders,
    val orderType: String = "Direct Orders",
)
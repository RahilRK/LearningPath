package com.brainvire.mvvm_clean_arch.presentation.shahen.navigation

import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.util.Constants.DASHBOARD
import com.brainvire.mvvm_clean_arch.util.Constants.DASHBOARD_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.MORE
import com.brainvire.mvvm_clean_arch.util.Constants.MORE_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_HISTORY
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_HISTORY_ROUTE


sealed class NavigationItem(val route: String, val label: String, val icons: Int) {

    object Dashboard : NavigationItem(
        route = DASHBOARD_ROUTE,
        label = DASHBOARD,
        icons = R.drawable.ic_dashboard
    )
    object OrderHistory : NavigationItem(
        route = ORDER_HISTORY_ROUTE,
        label = ORDER_HISTORY,
        icons = R.drawable.ic_order_history
    )

    object More : NavigationItem(
        route = MORE_ROUTE,
        label = MORE,
        icons = R.drawable.ic_more
    )
}
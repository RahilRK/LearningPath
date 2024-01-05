package com.brainvire.mvvm_clean_arch.presentation.shahen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.Dashboard
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.Login
import com.brainvire.mvvm_clean_arch.presentation.shahen.more.More
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.OrderHistory
import com.brainvire.mvvm_clean_arch.util.Constants.DASHBOARD_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.LOGIN_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.MORE_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_HISTORY_ROUTE

@Composable
fun NavigationController(
    startDestination: String = LOGIN_ROUTE,
    navController: NavHostController,
    paddingValues: PaddingValues,
    hideBottomNav: Boolean = false,
    hideBottomNavEvent: (hideBottomNav: Boolean) -> Unit = {},
) {
    val TAG = "NavigationController"

    NavHost(
        navController = navController,
        startDestination = DASHBOARD_ROUTE,
    ) {

        composable(LOGIN_ROUTE) {
            Login()
        }

        composable(DASHBOARD_ROUTE) {
            Dashboard()
        }
        composable(ORDER_HISTORY_ROUTE) {
            OrderHistory()
        }
        composable(MORE_ROUTE) {
            More()
        }
    }
}
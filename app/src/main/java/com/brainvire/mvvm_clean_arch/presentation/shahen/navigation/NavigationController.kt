package com.brainvire.mvvm_clean_arch.presentation.shahen.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.Dashboard
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.Login
import com.brainvire.mvvm_clean_arch.presentation.shahen.more.More
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.OrderHistory
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.OrderList
import com.brainvire.mvvm_clean_arch.util.Constants.DASHBOARD_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.LOGIN_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.MORE_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_HISTORY_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_LIST_ROUTE

@Composable
fun NavigationController(
    startDestination: String = LOGIN_ROUTE,
    navController: NavHostController,
    paddingValues: PaddingValues,
    preferenceManager: PreferenceManager
) {
    val TAG = "NavigationController"
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {

        composable(LOGIN_ROUTE) {
            Login(context, navController)
        }

        composable(DASHBOARD_ROUTE) {
            Dashboard()
        }

        composable(ORDER_HISTORY_ROUTE) {
            OrderHistory(onItemClick = { index, model ->
                navController.navigate("${ORDER_LIST_ROUTE}/${model.key}")
            })
        }

        composable(MORE_ROUTE) {
            More(logoutClick = {
                navController.navigate(LOGIN_ROUTE)
                val token = preferenceManager.getDeviceToken()
                preferenceManager.clearPreferences()
                preferenceManager.setDeviceToken(token)
                Toast.makeText(context, "Logout successfully", Toast.LENGTH_SHORT).show()
            })
        }

        composable("${ORDER_LIST_ROUTE}/{key}", arguments = listOf(
            navArgument("key") {
                type = NavType.StringType
            }
        )) { backStackEntry ->
            val key = backStackEntry.arguments!!.getString("key")
            OrderList(onBackPress = {
                navController.popBackStack()
            },)
        }
    }
}
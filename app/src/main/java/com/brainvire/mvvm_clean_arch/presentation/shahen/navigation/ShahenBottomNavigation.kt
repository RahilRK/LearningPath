package com.brainvire.mvvm_clean_arch.presentation.shahen.navigation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.LoginViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.bottom_tab_unselected
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color
import com.brainvire.mvvm_clean_arch.util.Constants
import com.brainvire.mvvm_clean_arch.util.Constants.DASHBOARD_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.LOGIN_ROUTE
import com.brainvire.mvvm_clean_arch.util.Constants.shahenCurrentScreen

@Composable
fun ShahenBottomNavigation() {

    val viewModel: LoginViewModel = hiltViewModel()
    val preferenceManager = viewModel.preferenceManager

    val navController = rememberNavController()
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: DASHBOARD_ROUTE

    val items = listOf(
        NavigationItem.Dashboard,
        NavigationItem.OrderHistory,
        NavigationItem.More,
    )

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    navController.addOnDestinationChangedListener { navController, destination, bundle ->
        destination.route?.let {
            Log.d(
                Constants.BottomNavigation,
                "addOnDestinationChangedListener: $it"
            )
//            bottomBarState.value = !it.contains("meal_detail")
            bottomBarState.value = !(it.contains("login") || it.contains("order_list"))
            shahenCurrentScreen = it
        }
    }

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarState.value,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
                content = {
                    BottomNavigation(backgroundColor = MaterialTheme.colors.background) {

                        items.forEach {
                            BottomNavigationItem(
                                selected = currentRoute == it.route,
                                onClick = {
                                    navController.navigate(it.route) {
                                        navController.graph.startDestinationRoute?.let { route ->
                                            Log.d(
                                                Constants.BottomNavigation,
                                                "startDestinationRoute: ${it.route}"
                                            )

                                            /*if(currentScreen != "search_meal") {
                                                popUpTo(route) {
                                                    saveState = true
                                                }
                                            }
                                            else {
                                                popUpTo(route) {
                                                    saveState = false
                                                }
                                            }*/

                                            popUpTo(route) {
                                                saveState = true
                                            }
                                        }

                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(id = it.icons),
                                        contentDescription = null,
                                        tint = if (currentRoute == it.route) shahen_app_color else bottom_tab_unselected
                                    )
                                },
                                label = {
                                    Text(
                                        text = it.label,
                                        color = if (currentRoute == it.route) shahen_app_color else bottom_tab_unselected
                                    )
                                })
                        }
                    }

                }
            )
        }
    ) { it ->
        NavigationController(
            startDestination = if (preferenceManager.isLogin()) DASHBOARD_ROUTE else LOGIN_ROUTE,
            navController = navController,
            it,
        )
    }
}
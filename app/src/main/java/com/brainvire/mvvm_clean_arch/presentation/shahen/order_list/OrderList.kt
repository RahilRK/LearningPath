package com.brainvire.mvvm_clean_arch.presentation.shahen.order_list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.SearchView
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.TopBar
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.OrderHistoryViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.component.OrderDashboardGridOrdersList
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.component.OrderHistoryList

@Composable
fun OrderList(onBackPress: () -> Unit = {}) {

    var TAG = "OrderList"

    val viewModel: OrderListViewModel = hiltViewModel()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            TopBar(
                onBackPress = onBackPress,
                showBackArrow = true,
                showTitle = true,
                title = "Order History"
            )

            Column(Modifier.padding(8.dp)) {

                SearchView(
                    searchKey = viewModel.searchKey.collectAsState().value,
                    onSearchType = { searchKey ->
                        viewModel.setSearchKey(searchKey)
                    }
                )

                OrderHistoryList(viewModel)
            }
        }
    }
}
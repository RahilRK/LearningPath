package com.brainvire.mvvm_clean_arch.presentation.shahen.order_history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.LoadingDialog
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.TopBar
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.component.OrderDashboardGridOrdersList

@Preview
@Composable
fun OrderHistory() {

    val TAG = "OrderHistory"

    val viewModel: OrderHistoryViewModel = hiltViewModel()
    val isLoadingState = viewModel.isLoadingState.collectAsState().value

    Box {
        if (isLoadingState) {
            LoadingDialog()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            TopBar(
                showTitle = true,
                title = "Order History"
            )

            Column(Modifier.padding(8.dp)) {
                OrderDashboardGridOrdersList(viewModel)
            }
        }
    }
}
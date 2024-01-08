package com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.OrderHistoryViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.state.OrderHistoryState

@Composable
fun OrderDashboardGridOrdersList(viewModel: OrderHistoryViewModel = hiltViewModel()) {

    val TAG = "OrderDashboardGridOrdersList"

    val context = LocalContext.current
    val lazyListState: LazyGridState = rememberLazyGridState()

    val orderHistoryDashboardState =
        viewModel.orderHistoryDashboardState.collectAsState(initial = OrderHistoryState.Loading)
    when (val result = orderHistoryDashboardState.value) {
        OrderHistoryState.Loading -> {
            Log.d(TAG, "OrderHistoryState: Loading")
        }

        is OrderHistoryState.Success -> {
            Log.d(TAG, "OrderHistoryState: Success: ${result.list}")
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(top = 12.dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                state = lazyListState
            ) {
                itemsIndexed(result.list.toList()) { index, model ->

                    OrderDashboardItem(
                        model = model,
                    )
                }
            }
        }

        is OrderHistoryState.Empty -> {
            Log.d(TAG, "OrderHistoryState: Empty")
        }

        is OrderHistoryState.Error -> {
            Log.e(TAG, "OrderHistoryState: Error")
        }
    }
}
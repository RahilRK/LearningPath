package com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.component

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.LoadingDialog
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.OrderListViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.state.OrderListState

@Composable
fun OrderHistoryList(
    viewModel: OrderListViewModel = hiltViewModel(),
    onItemClick: (index: Int, model: Data) -> Unit = { pos: Int, mModel: Data -> }
) {

    val TAG = "OrderHistoryList"

    val context = LocalContext.current
    val lazyListState: LazyListState = rememberLazyListState()

    val orderHistoryDashboardState =
        viewModel.orderListDashboardState.collectAsState(initial = OrderListState.Loading)
    when (val result = orderHistoryDashboardState.value) {
        OrderListState.Loading -> {
            Log.d(TAG, "OrderListState: Loading")
            LoadingDialog()
        }

        is OrderListState.Success -> {
            Log.d(TAG, "OrderListState: Success: ${result.list}")
            LazyColumn(
                modifier = Modifier
                    .padding(top = 12.dp),
                state = lazyListState
            ) {
                itemsIndexed(result.list.toList()) { index, model ->

                    OrderHistoryListItem(
                        model = model
                    )
                }
            }
        }

        is OrderListState.Empty -> {
            Log.d(TAG, "OrderListState: Empty")
        }

        is OrderListState.Error -> {
            Log.e(TAG, "OrderListState: Error: ${result.errorMsg}")
        }
    }
}
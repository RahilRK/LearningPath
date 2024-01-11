package com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.state

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data
import com.brainvire.mvvm_clean_arch.data.model.response.order_history.RespOrderHistoryList

sealed class OrderListState {
    object Empty : OrderListState()
    object Loading : OrderListState()
    data class Success(val list: SnapshotStateList<RespOrderHistoryList.Data>) : OrderListState()
    data class Error(val errorMsg: String) : OrderListState()
}
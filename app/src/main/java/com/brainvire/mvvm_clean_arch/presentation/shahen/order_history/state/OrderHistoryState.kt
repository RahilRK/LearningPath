package com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.state

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data

sealed class OrderHistoryState {
    object Empty : OrderHistoryState()
    object Loading : OrderHistoryState()
    data class Success(val list: SnapshotStateList<Data>) : OrderHistoryState()
    data class Error(val errorMsg: String) : OrderHistoryState()
}
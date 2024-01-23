package com.brainvire.mvvm_clean_arch.presentation.pagination.state

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data
import com.brainvire.mvvm_clean_arch.data.model.response.food2fork.RespFood2Fork

sealed class FoodListState {
    object Empty : FoodListState()
    object Loading : FoodListState()
    data class Success(val list: SnapshotStateList<RespFood2Fork.Result?>, val isLoadMore: Boolean) : FoodListState()
    data class Error(val errorMsg: String) : FoodListState()
}
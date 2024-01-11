package com.brainvire.mvvm_clean_arch.presentation.shahen.order_list

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainvire.mvvm_clean_arch.common.orFalse
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.request.ReqOrderHistoryList
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.domain.usecase.order_history.OrderHistoryListUseCase
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.state.OrderListState
import com.brainvire.mvvm_clean_arch.util.Constants
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderListViewModel @Inject constructor(
    private val orderHistoryListUseCase: OrderHistoryListUseCase,
    val preferenceManager: PreferenceManager,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var TAG = "OrderListViewModel"

    private val _searchKey = MutableStateFlow("")
    val searchKey: StateFlow<String>
        get() = _searchKey.asStateFlow()

    fun setSearchKey(value: String) {
        _searchKey.value = value
        viewModelScope.launch {
            delay(1000L)
            orderList(model = ReqOrderHistoryList(
                pType = savedStateHandle.get<String>("key") ?: "new",
                page = 1,
                perPage = 10,
                section = Constants.SECTION_ORDER_HISTORY,
                searchText = searchKey.value
            ))
        }
    }

    private val _orderListDashboardState =
        MutableStateFlow<OrderListState>(OrderListState.Loading)
    val orderListDashboardState: StateFlow<OrderListState>
        get() = _orderListDashboardState

    init {
        orderList(model = ReqOrderHistoryList(
            pType = savedStateHandle.get<String>("key") ?: "new",
            page = 1,
            perPage = 10,
            section = Constants.SECTION_ORDER_HISTORY
        ))
    }

    private fun orderList(model: ReqOrderHistoryList) {
        orderHistoryListUseCase.invoke(model).onEach { result ->
            when (result) {
                is Resource.Loading -> {

                    _orderListDashboardState.emit(OrderListState.Loading)
                }

                is Resource.Idle -> {

                    _orderListDashboardState.emit(OrderListState.Loading)
                }

                is Resource.Success -> {

                    val list = result.data?.data?.data?.toMutableStateList()
                    if (list.isNullOrEmpty()) {
                        _orderListDashboardState.emit(OrderListState.Empty)
                    } else {
                        _orderListDashboardState.emit(OrderListState.Success(list = list))
                    }
                }

                is Resource.Error<*> -> {

                    _orderListDashboardState.emit(
                        OrderListState.Error(
                            errorMsg = result.message ?: "An unexpected error occurred"
                        )
                    )

                    val jsonObject = result.errorData as? JsonObject
                    val jsonData = jsonObject?.entrySet()
                    if (jsonData == null || jsonData.isEmpty().orFalse()) {
                        result.errorMessage?.let { OrderListState.Error(errorMsg = it) }
                            ?.let { _orderListDashboardState.emit(it) }
                    } else {
                        var error: String = ""
                        jsonData.forEach { (_, value) ->
                            if (value.isJsonArray) {
                                value.asJsonArray.forEach { jsonElement ->
                                    error += jsonElement.asString + " \n "
                                }
                            } else {
                                error += value.asString + " \n "
                            }
                        }
                        _orderListDashboardState.emit(OrderListState.Error(errorMsg = error))
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}

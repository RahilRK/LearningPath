package com.brainvire.mvvm_clean_arch.presentation.shahen.order_history

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainvire.mvvm_clean_arch.common.orFalse
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.request.ReqDirectOrderDashboard
import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.domain.usecase.MyProfileUseCase
import com.brainvire.mvvm_clean_arch.domain.usecase.direct_order.DirectOrderDashboardUseCase
import com.brainvire.mvvm_clean_arch.domain.usecase.notification.GetUnreadNotificationUseCase
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state.MyProfileStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state.UnreadNotificationStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.state.LoginStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.state.TextFieldState
import com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.state.OrderHistoryState
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OrderHistoryViewModel @Inject constructor(
    private val directOrderDashboardUseCase: DirectOrderDashboardUseCase,
    val preferenceManager: PreferenceManager
) : ViewModel() {

    var TAG = "OrderHistoryViewModel"

    private val _orderHistoryDashboardState =
        MutableStateFlow<OrderHistoryState>(OrderHistoryState.Loading)
    val orderHistoryDashboardState: StateFlow<OrderHistoryState>
        get() = _orderHistoryDashboardState

    init {
        orderHistoryDashboard(model = ReqDirectOrderDashboard(section = "all"))
    }

    private fun orderHistoryDashboard(model: ReqDirectOrderDashboard) {
        directOrderDashboardUseCase.invoke(model).onEach { result ->
            when (result) {
                is Resource.Loading -> {

                    _orderHistoryDashboardState.emit(OrderHistoryState.Loading)
                }

                is Resource.Idle -> {

                    _orderHistoryDashboardState.emit(OrderHistoryState.Loading)
                }

                is Resource.Success -> {

                    val list = result.data?.data?.toMutableStateList()
                    if (list.isNullOrEmpty()) {
                        _orderHistoryDashboardState.emit(OrderHistoryState.Empty)
                    } else {
                        _orderHistoryDashboardState.emit(OrderHistoryState.Success(list = list))
                    }
                }

                is Resource.Error<*> -> {

                    _orderHistoryDashboardState.emit(
                        OrderHistoryState.Error(
                            errorMsg = result.message ?: "An unexpected error occurred"
                        )
                    )

                    val jsonObject = result.errorData as? JsonObject
                    val jsonData = jsonObject?.entrySet()
                    if (jsonData == null || jsonData.isEmpty().orFalse()) {
                        result.errorMessage?.let { OrderHistoryState.Error(errorMsg = it) }
                            ?.let { _orderHistoryDashboardState.emit(it) }
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
                        _orderHistoryDashboardState.emit(OrderHistoryState.Error(errorMsg = error))
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}

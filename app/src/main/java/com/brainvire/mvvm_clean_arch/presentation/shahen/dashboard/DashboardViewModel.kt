package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainvire.mvvm_clean_arch.common.orFalse
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.CurrentOrder
import com.brainvire.mvvm_clean_arch.domain.usecase.MyProfileUseCase
import com.brainvire.mvvm_clean_arch.domain.usecase.dashboard.DashboardUseCase
import com.brainvire.mvvm_clean_arch.domain.usecase.notification.GetUnreadNotificationUseCase
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state.DashboardStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state.MyProfileStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state.UnreadNotificationStateHandler
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val myProfileUseCase: MyProfileUseCase,
    private val getUnreadNotificationUseCase: GetUnreadNotificationUseCase,
    private val dashboardUseCase: DashboardUseCase,
    val preferenceManager: PreferenceManager
) : ViewModel() {

    var TAG = "DashboardViewModel"

    private val _myProfileState = MutableStateFlow(MyProfileStateHandler(isLoading = true))
    val myProfileState: StateFlow<MyProfileStateHandler> = _myProfileState

    private val _unreadNotificationState =
        MutableStateFlow(UnreadNotificationStateHandler(isLoading = true))
    val unreadNotificationState: StateFlow<UnreadNotificationStateHandler> =
        _unreadNotificationState

    private val _dashboardState =
        MutableStateFlow(DashboardStateHandler(isLoading = true))
    val dashboardState: StateFlow<DashboardStateHandler> =
        _dashboardState

    private val _notificationCount = MutableStateFlow(0.0)
    val notificationCount: StateFlow<Double>
        get() = _notificationCount.asStateFlow()

    private val _newOrderList = mutableStateListOf<CurrentOrder>()
    val newOrderList
        get() = _newOrderList

    init {
        myProfile()
        unreadNotification()
        dashboardData()
    }

    private fun myProfile() {
        myProfileUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {

                    _myProfileState.emit(MyProfileStateHandler(isLoading = true))
                }

                is Resource.Idle -> {

                    _myProfileState.emit(MyProfileStateHandler(isLoading = true))
                }

                is Resource.Success -> {

                    _myProfileState.emit(result.data?.let { MyProfileStateHandler(data = it) }!!)
                }

                is Resource.Error<*> -> {

                    _myProfileState.emit(
                        MyProfileStateHandler(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    )

                    val jsonObject = result.errorData as? JsonObject
                    val jsonData = jsonObject?.entrySet()
                    if (jsonData == null || jsonData.isEmpty().orFalse()) {
                        _myProfileState.emit(
                            MyProfileStateHandler(
                                error = result.errorMessage!!
                            )
                        )
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

                        _myProfileState.emit(
                            MyProfileStateHandler(
                                error = error
                            )
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun unreadNotification() {
        getUnreadNotificationUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {

                    _unreadNotificationState.emit(UnreadNotificationStateHandler(isLoading = true))
                }

                is Resource.Idle -> {

                    _unreadNotificationState.emit(UnreadNotificationStateHandler(isLoading = true))
                }

                is Resource.Success -> {

                    _unreadNotificationState.emit(result.data?.let {
                        _notificationCount.emit(it.data as Double)
                        UnreadNotificationStateHandler(
                            data = it
                        )
                    }!!)
                }

                is Resource.Error<*> -> {

                    _unreadNotificationState.emit(
                        UnreadNotificationStateHandler(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    )

                    val jsonObject = result.errorData as? JsonObject
                    val jsonData = jsonObject?.entrySet()
                    if (jsonData == null || jsonData.isEmpty().orFalse()) {
                        _unreadNotificationState.emit(
                            UnreadNotificationStateHandler(
                                error = result.errorMessage!!
                            )
                        )
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

                        _unreadNotificationState.emit(
                            UnreadNotificationStateHandler(
                                error = error
                            )
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun dashboardData() {
        dashboardUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {

                    _dashboardState.emit(DashboardStateHandler(isLoading = true))
                }

                is Resource.Idle -> {

                    _dashboardState.emit(DashboardStateHandler(isLoading = true))
                }

                is Resource.Success -> {

                    _dashboardState.emit(result.data?.let {
                        val newOrderList = result.data.data?.newOrder
                        newOrderList?.let {
                            val newOrdersCollection: Collection<CurrentOrder> = ArrayList<CurrentOrder>(it)
                            _newOrderList.addAll(newOrdersCollection)
                        }
                        DashboardStateHandler(
                            data = it
                        )
                    }!!)
                }

                is Resource.Error<*> -> {

                    _dashboardState.emit(
                        DashboardStateHandler(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    )

                    val jsonObject = result.errorData as? JsonObject
                    val jsonData = jsonObject?.entrySet()
                    if (jsonData == null || jsonData.isEmpty().orFalse()) {
                        _unreadNotificationState.emit(
                            UnreadNotificationStateHandler(
                                error = result.errorMessage!!
                            )
                        )
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

                        _dashboardState.emit(
                            DashboardStateHandler(
                                error = error
                            )
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}

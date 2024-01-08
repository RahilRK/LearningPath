package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainvire.mvvm_clean_arch.common.orFalse
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.domain.usecase.MyProfileUseCase
import com.brainvire.mvvm_clean_arch.domain.usecase.notification.GetUnreadNotificationUseCase
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state.MyProfileStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state.UnreadNotificationStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.state.LoginStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.state.TextFieldState
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
    val preferenceManager: PreferenceManager
) : ViewModel() {

    var TAG = "DashboardViewModel"

    private val _isLoadingState = MutableStateFlow(false)
    val isLoadingState: StateFlow<Boolean>
        get() = _isLoadingState.asStateFlow()

    private val _myProfileState = MutableStateFlow(MyProfileStateHandler(isLoading = true))
    val myProfileState: StateFlow<MyProfileStateHandler> = _myProfileState

    private val _unreadNotificationState =
        MutableStateFlow(UnreadNotificationStateHandler(isLoading = true))
    val unreadNotificationState: StateFlow<UnreadNotificationStateHandler> =
        _unreadNotificationState

    private val _notificationCount = MutableStateFlow(0.0)
    val notificationCount: StateFlow<Double>
        get() = _notificationCount.asStateFlow()

    init {
        myProfile()
        unreadNotification()
    }

    private fun myProfile() {
        myProfileUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {

                    _isLoadingState.emit(true)
                    _myProfileState.emit(MyProfileStateHandler(isLoading = true))
                }

                is Resource.Idle -> {

                    _isLoadingState.emit(false)
                    _myProfileState.emit(MyProfileStateHandler(isLoading = true))
                }

                is Resource.Success -> {

                    _isLoadingState.emit(false)
                    _myProfileState.emit(result.data?.let { MyProfileStateHandler(data = it) }!!)
                }

                is Resource.Error<*> -> {

                    _isLoadingState.emit(false)
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

                    _isLoadingState.emit(true)
                    _unreadNotificationState.emit(UnreadNotificationStateHandler(isLoading = true))
                }

                is Resource.Idle -> {

                    _isLoadingState.emit(false)
                    _unreadNotificationState.emit(UnreadNotificationStateHandler(isLoading = true))
                }

                is Resource.Success -> {

                    _isLoadingState.emit(false)
                    _unreadNotificationState.emit(result.data?.let {
                        _notificationCount.emit(it.data as Double)
                        UnreadNotificationStateHandler(
                            data = it
                        )
                    }!!)
                }

                is Resource.Error<*> -> {

                    _isLoadingState.emit(false)
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
}

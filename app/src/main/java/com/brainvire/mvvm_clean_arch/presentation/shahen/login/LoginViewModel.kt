package com.brainvire.mvvm_clean_arch.presentation.shahen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainvire.mvvm_clean_arch.common.isEmailValid
import com.brainvire.mvvm_clean_arch.common.isPasswordValid
import com.brainvire.mvvm_clean_arch.common.orFalse
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.domain.usecase.LoginUseCase
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.state.LoginStateHandler
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.state.TextFieldState
import com.brainvire.mvvm_clean_arch.util.Constants.PLATFORM
import com.brainvire.mvvm_clean_arch.util.Constants.SERVICE_PROVIDER
import com.brainvire.mvvm_clean_arch.util.ResponseHandler
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    val preferenceManager: PreferenceManager
) : ViewModel() {

    var TAG = "LoginViewModel"

    private val _isLoadingState = MutableStateFlow(false)
    val isLoadingState: StateFlow<Boolean>
        get() = _isLoadingState.asStateFlow()

    private val _emailState = mutableStateOf(TextFieldState())
    val emailState: State<TextFieldState> = _emailState

    fun setEmail(value: String) {
        _emailState.value = emailState.value.copy(text = value, error = "")
    }

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState: State<TextFieldState> = _passwordState

    fun setPassword(value: String) {
        _passwordState.value = passwordState.value.copy(text = value, error = "")
    }

    private val _showPasswordState = MutableStateFlow(false)
    val showPasswordState: StateFlow<Boolean>
        get() = _showPasswordState.asStateFlow()

    fun setShowPassword(value: Boolean) {
        _showPasswordState.value = value
    }

    private val _loginState = MutableStateFlow(LoginStateHandler(isLoading = true))
    val loginState: StateFlow<LoginStateHandler> = _loginState

    private val _errorMsg = MutableStateFlow("")
    val errorMsg: StateFlow<String>
        get() = _errorMsg.asStateFlow()

    fun setErrorMsg(value: String) {
        _errorMsg.value = value
    }

    fun isValid() {
        if (_emailState.value.text.isEmpty()) {
            _emailState.value = _emailState.value.copy(error = "Please enter Email ID")
        } else if (!_emailState.value.text.isEmailValid()) {
            _emailState.value = _emailState.value.copy(error = "Invalid Email ID")
        } else if (_passwordState.value.text.isEmpty()) {
            _passwordState.value = _passwordState.value.copy(error = "Please enter Password")
        } else if (!_passwordState.value.text.isPasswordValid()) {
            _passwordState.value =
                _passwordState.value.copy(error = "Password should be between 8 to 30 characters")
        } else {
            login(
                ReqLogin(
                    role = SERVICE_PROVIDER,
                    email = _emailState.value.text,
                    password = _passwordState.value.text,
                    deviceToken = "fAHOlvQmSXmQlrbO8zWKhG:APA91bE3p-e4Q5oFqtGTY6PdxErnDBRtnvUkRyMNh93kek9Q8OVjV8n63UJpyXsQiMzyH1pipBhSVlBqu4k0_c7OBZhmUGRXrX8i0CWucWELW3CIlYWulnCtWBf0xBiXSl8yVvnO3sFy",
                    platform = PLATFORM
                )
            )
        }
    }

    fun login(model: ReqLogin) {
        loginUseCase.invoke(model).onEach { result ->
            when (result) {
                is Resource.Loading -> {

                    _isLoadingState.emit(true)
                    _loginState.emit(LoginStateHandler(isLoading = true))
                }

                is Resource.Idle -> {

                    _isLoadingState.emit(false)
                    _loginState.emit(LoginStateHandler(isLoading = true))
                }

                is Resource.Success -> {

                    _isLoadingState.emit(false)
                    _loginState.emit(result.data?.let { LoginStateHandler(data = it) }!!)
                }

                is Resource.Error<*> -> {

                    _isLoadingState.emit(false)
                    _loginState.emit(
                        LoginStateHandler(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    )

                    val jsonObject = result.errorData as? JsonObject
                    val jsonData = jsonObject?.entrySet()
                    if (jsonData == null || jsonData.isEmpty().orFalse()) {
                        _loginState.emit(
                            LoginStateHandler(
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

                        _loginState.emit(
                            LoginStateHandler(
                                error = error
                            )
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
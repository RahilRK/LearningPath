package com.brainvire.mvvm_clean_arch.presentation.shahen.navigation

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
class ShahenBottomNavigationViewModel @Inject constructor(
    val preferenceManager: PreferenceManager
) : ViewModel() {

    var TAG = "ShahenBottomNavigationViewModel"

   }
package com.brainvire.mvvm_clean_arch.presentation.shahen.login.state

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.shahen.provider.core.models.responses.login.RespLogin

sealed class LoginState {
    object Empty : LoginState()
    object Loading : LoginState()
    data class Success(val data: AppResponse<RespLogin>) : LoginState()
    data class Error(val errorMsg: String) : LoginState()
}
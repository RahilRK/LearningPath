package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.my_profile.RespMyProfile

data class UnreadNotificationStateHandler(
    val isLoading: Boolean = false,
    val data: AppResponse<Any>? = null,
    val error: String = ""
)

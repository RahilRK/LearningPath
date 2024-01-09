package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.state

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.MainDashboardResponse

data class DashboardStateHandler(
    val isLoading: Boolean = false,
    val data: AppResponse<MainDashboardResponse>? = null,
    val error: String = ""
)

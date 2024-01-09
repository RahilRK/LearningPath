package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.MainDashboardResponse

interface DashboardRepository {
    suspend fun getMainDashboardData(): Resource<AppResponse<MainDashboardResponse>>
/*
    suspend fun contactUs(model: ReqContactUs): Resource<AppResponse<Any>>
*/
}
package com.brainvire.mvvm_clean_arch.domain.usecase.dashboard

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.MainDashboardResponse
import com.brainvire.mvvm_clean_arch.domain.repository.DashboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DashboardUseCase @Inject constructor(private val repository: DashboardRepository) {
    operator fun invoke(): Flow<Resource<AppResponse<MainDashboardResponse>>> = flow {
        emit(Resource.Loading)
        val response = repository.getMainDashboardData()
        emit(response)
    }
}
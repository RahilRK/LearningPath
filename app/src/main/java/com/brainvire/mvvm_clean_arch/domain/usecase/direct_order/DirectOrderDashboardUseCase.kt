package com.brainvire.mvvm_clean_arch.domain.usecase.direct_order

import com.brainvire.mvvm_clean_arch.data.model.request.ReqDirectOrderDashboard
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data
import com.brainvire.mvvm_clean_arch.domain.repository.DirectOrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DirectOrderDashboardUseCase @Inject constructor(private val repository: DirectOrderRepository) {
    operator fun invoke(model: ReqDirectOrderDashboard): Flow<Resource<AppResponse<List<Data>>>> =
        flow {
            emit(Resource.Loading)
            val response = repository.directOrderDashboard(model)
            emit(response)
        }
}

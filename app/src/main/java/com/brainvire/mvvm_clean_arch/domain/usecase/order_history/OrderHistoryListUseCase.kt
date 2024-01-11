package com.brainvire.mvvm_clean_arch.domain.usecase.order_history

import com.brainvire.mvvm_clean_arch.data.model.request.ReqOrderHistoryList
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.order_history.RespOrderHistoryList
import com.brainvire.mvvm_clean_arch.domain.repository.OrderHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrderHistoryListUseCase @Inject constructor(private val repository: OrderHistoryRepository) {
    operator fun invoke(model: ReqOrderHistoryList): Flow<Resource<AppResponse<RespOrderHistoryList>>> =
        flow {
            emit(Resource.Loading)
            val response = repository.orderHistoryList(model)
            emit(response)
        }
}

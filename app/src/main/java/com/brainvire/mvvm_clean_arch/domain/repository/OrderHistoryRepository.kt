package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.request.ReqOrderHistoryList
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.order_history.RespOrderHistoryList

interface OrderHistoryRepository {
    suspend fun orderHistoryList(model: ReqOrderHistoryList): Resource<AppResponse<RespOrderHistoryList>>
}

package com.brainvire.mvvm_clean_arch.data.repository_impl

import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.request.ReqOrderHistoryList
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.order_history.RespOrderHistoryList
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.di.makeAPICall
import com.brainvire.mvvm_clean_arch.domain.repository.OrderHistoryRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderHistoryRepImplement @Inject constructor(
    private val apiInterface: ApiInterface,
    private val preferenceManager: PreferenceManager,
    private val gson: Gson
) : OrderHistoryRepository {
    override suspend fun orderHistoryList(model: ReqOrderHistoryList): Resource<AppResponse<RespOrderHistoryList>> {
        val response = makeAPICall(gson) {
            apiInterface.orderHistoryList(model)
        }
        return response
    }
}
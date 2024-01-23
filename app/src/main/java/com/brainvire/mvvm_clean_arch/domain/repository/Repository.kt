package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import com.brainvire.mvvm_clean_arch.data.model.request.ReqOrderHistoryList
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.food2fork.RespFood2Fork
import com.brainvire.mvvm_clean_arch.data.model.response.order_history.RespOrderHistoryList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {


    /*todo getData*/
    suspend fun getCategory(): Response<CategoryListRespDTO>

//    suspend fun getFoodList(page: Int, query: String): Resource<AppResponse<RespFood2Fork>>
    suspend fun getFoodList(page: Int, query: String): Response<RespFood2Fork>
}
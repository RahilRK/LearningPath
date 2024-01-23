package com.brainvire.mvvm_clean_arch.data.repository_impl

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.food2fork.RespFood2Fork
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.di.makeAPICall
import com.brainvire.mvvm_clean_arch.domain.repository.Repository
import com.google.gson.Gson
import retrofit2.http.Path
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val gson: Gson
) : Repository {
    /*
        override fun getCategory(): Flow<CategoryListRespDTO> {
            return flow {
                apiInterface.getCategoryList()
            }
        }
    */

    override suspend fun getCategory() = apiInterface.getCategoryList()

    /*
        override suspend fun getFoodList(page: Int, query: String): Resource<AppResponse<RespFood2Fork>> {
            val response = makeAPICall(gson) {
                apiInterface.getFoodList(page = page, query = query)
            }
            return response
        }
    */
    override suspend fun getFoodList(page: Int, query: String) = apiInterface.getFoodList(page = page, query = query)
}
package com.brainvire.mvvm_clean_arch.data.repository

import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
): Repository {
/*
    override fun getCategory(): Flow<CategoryListRespDTO> {
        return flow {
            apiInterface.getCategoryList()
        }
    }
*/

    override suspend fun getCategory() = apiInterface.getCategoryList()
}
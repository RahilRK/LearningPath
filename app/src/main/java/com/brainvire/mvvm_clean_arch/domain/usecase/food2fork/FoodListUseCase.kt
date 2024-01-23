package com.brainvire.mvvm_clean_arch.domain.usecase.food2fork

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.food2fork.RespFood2Fork
import com.brainvire.mvvm_clean_arch.domain.repository.Repository
import com.brainvire.mvvm_clean_arch.util.ResponseHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodListUseCase @Inject constructor(
    private val repository: Repository
) {
    var TAG = "FoodListUseCase"

    operator fun invoke(page: Int, query: String): Flow<ResponseHandler<RespFood2Fork?>> = flow {

        emit(ResponseHandler.Loading())
        val response = repository.getFoodList(page = page, query = query)
        emit(ResponseHandler.Success(response.body()))
    }
}
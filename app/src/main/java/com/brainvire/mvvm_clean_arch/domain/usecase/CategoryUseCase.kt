package com.brainvire.mvvm_clean_arch.domain.usecase

import android.util.Log
import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import com.brainvire.mvvm_clean_arch.data.model.toCategoryList
import com.brainvire.mvvm_clean_arch.domain.model.Category
import com.brainvire.mvvm_clean_arch.domain.repository.Repository
import com.brainvire.mvvm_clean_arch.util.ResponseHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val repository: Repository
) {
    var TAG = "CategoryUseCase"

    operator fun invoke(): Flow<ResponseHandler<List<Category?>>> = flow {
        try {
            emit(ResponseHandler.Loading())

            val response = repository.getCategory()
            val mealList = if (response.body()?.categories?.isNotEmpty() == true) {
                response.body()!!.categories!!.map { it -> it?.toCategoryList() }
            } else {
                emptyList()
            }

            emit(ResponseHandler.Success(mealList))

            /*val res = repository.getCategory()
            res
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.e(TAG, "invoke: catch: ${it.printStackTrace()}")
                    emit(ResponseHandler.Error("Error in showing category list"))
                }
                .collect {
                    Log.d(TAG, "invoke: ${it.categories?.size}")
                    emit(ResponseHandler.Success(it))
                }*/

            /*val response = repository.getCategory()
            val list = response.map { list ->
                list.map { model ->
                    model.toCategoryList()
                }
            }

            list
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.e(TAG, "invoke: catch: ${it.printStackTrace()}")
                    emit(ResponseHandler.Error("Error in showing category list"))
                }
                .collect {
                    if (it.isNotEmpty()) {
                        emit(ResponseHandler.Success(it))
                    } else {
                        emptyList<Category>()
                    }
                }*/


        } catch (e: HttpException) {
            emit(ResponseHandler.Error("An unexpected error occurred"))
        } catch (e: IOException) {
            emit(ResponseHandler.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
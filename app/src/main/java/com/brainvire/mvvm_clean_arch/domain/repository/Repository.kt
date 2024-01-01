package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {


    /*todo getData*/
    suspend fun getCategory(): Response<CategoryListRespDTO>
}
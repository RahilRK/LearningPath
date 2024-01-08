package com.brainvire.mvvm_clean_arch.domain.usecase

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.my_profile.RespMyProfile
import com.brainvire.mvvm_clean_arch.domain.repository.MyProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MyProfileUseCase @Inject constructor(private val repository: MyProfileRepository) {
    operator fun invoke(): Flow<Resource<AppResponse<RespMyProfile>>> = flow {
        emit(Resource.Loading)
        val response = repository.myProfileData()
        emit(response)
    }
}
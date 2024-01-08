package com.brainvire.mvvm_clean_arch.domain.usecase

import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.domain.repository.LoginRepository
import com.shahen.provider.core.models.responses.login.RespLogin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    var TAG = "LoginUseCase"

    operator fun invoke(model: ReqLogin): Flow<Resource<AppResponse<RespLogin>>> = flow {

        emit(Resource.Loading)
        val response = loginRepository.login(model)
        emit(response)
    }
}
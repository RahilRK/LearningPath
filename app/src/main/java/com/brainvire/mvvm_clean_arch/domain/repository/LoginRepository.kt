package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.shahen.provider.core.models.responses.login.RespLogin
import retrofit2.Response

interface LoginRepository {
    suspend fun login(model: ReqLogin): Resource<AppResponse<RespLogin>>
}
package com.brainvire.mvvm_clean_arch.data.repository_impl

import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.di.makeAPICall
import com.brainvire.mvvm_clean_arch.domain.repository.LoginRepository
import com.google.gson.Gson
import com.shahen.provider.core.models.responses.login.RespLogin
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepImplement @Inject constructor(
    private val apiInterface: ApiInterface,
    private val gson: Gson
) : LoginRepository {

    override suspend fun login(model: ReqLogin): Resource<AppResponse<RespLogin>> {
        val response = makeAPICall(gson) {
            apiInterface.login(model)
        }
        return response
    }
}
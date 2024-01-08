package com.brainvire.mvvm_clean_arch.data.repository_impl

import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.my_profile.RespMyProfile
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.di.makeAPICall
import com.brainvire.mvvm_clean_arch.domain.repository.MyProfileRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyProfileRepImplement @Inject constructor(
    private val apiInterface: ApiInterface,
    private val preferenceManager: PreferenceManager,
    private val gson: Gson
) : MyProfileRepository {
    override suspend fun myProfileData(): Resource<AppResponse<RespMyProfile>> {
        val response = makeAPICall(gson) {
            apiInterface.myProfileData()
        }
        return response
    }

/*    override suspend fun changePassword(model: ReqChangePassword): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            profileApi.changePassword(model)
        }
        return response
    }

    override suspend fun editAccountProfileDetail(model: ReqEditAccountProfileDetail): Resource<AppResponse<RespMyProfile>> {
        val response = makeAPICall(gson) {
            profileApi.editAccountProfileDetail(model)
        }
        return response
    }
    override suspend fun editAccountProfilePicture(model: ReqEditAccountProfilePicture): Resource<AppResponse<RespMyProfile>> {
        val response = makeAPICall(gson) {
            profileApi.editAccountProfilePicture(model)
        }
        return response
    }

    override suspend fun editProfileDocumentDetail(model: ReqEditProfileDocumentDetail): Resource<AppResponse<RespMyProfile>> {
        val response = makeAPICall(gson) {
            profileApi.editProfileDocumentDetail(preferenceManager.getUserId(), model)
        }
        return response
    }
    override suspend fun editProfileCompanyAddressDetail(model: ReqEditProfileCompanyAddressDetail): Resource<AppResponse<RespMyProfile>> {
        val response = makeAPICall(gson) {
            profileApi.editProfileCompanyAddressDetail(preferenceManager.getUserId(), model)
        }
        return response
    }

    override suspend fun deleteAccount(): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            profileApi.deleteAccount()
        }
        return response
    }*/
}
package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.my_profile.RespMyProfile

interface MyProfileRepository {
    suspend fun myProfileData(): Resource<AppResponse<RespMyProfile>>
    /*suspend fun changePassword(model: ReqChangePassword): Resource<AppResponse<Any>>
    suspend fun editAccountProfileDetail(model: ReqEditAccountProfileDetail): Resource<AppResponse<RespMyProfile>>
    suspend fun editAccountProfilePicture(model: ReqEditAccountProfilePicture): Resource<AppResponse<RespMyProfile>>
    suspend fun deleteAccount(): Resource<AppResponse<Any>>
    suspend fun editProfileDocumentDetail(model: ReqEditProfileDocumentDetail): Resource<AppResponse<RespMyProfile>>
    suspend fun editProfileCompanyAddressDetail(model: ReqEditProfileCompanyAddressDetail): Resource<AppResponse<RespMyProfile>>*/
}
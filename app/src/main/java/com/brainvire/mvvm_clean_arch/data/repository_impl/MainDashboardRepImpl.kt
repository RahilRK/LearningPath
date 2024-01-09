package com.brainvire.mvvm_clean_arch.data.repository_impl

import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.MainDashboardResponse
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.di.makeAPICall
import com.brainvire.mvvm_clean_arch.domain.repository.DashboardRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainDashboardRepImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val preferenceManager: PreferenceManager,
    private val gson: Gson
) : DashboardRepository {
    override suspend fun getMainDashboardData(): Resource<AppResponse<MainDashboardResponse>> {
        val response = makeAPICall(gson) {
            apiInterface.getMainDashboardData()
        }
        return response
    }

/*
    override suspend fun contactUs(model: ReqContactUs): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            dashboardApi.contactUs(model)
        }
        return response
    }
*/
}
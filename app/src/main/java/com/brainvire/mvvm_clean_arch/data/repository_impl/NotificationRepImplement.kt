package com.brainvire.mvvm_clean_arch.data.repository_impl

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.di.makeAPICall
import com.brainvire.mvvm_clean_arch.domain.repository.NotificationRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationRepImplement @Inject constructor(
    private val apiInterface: ApiInterface,
    private val gson: Gson
) : NotificationRepository
{
    override suspend fun unreadNotificationCount(): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            apiInterface.unreadNotificationCount()
        }
        return response
    }

    /*override suspend fun notificationList(model: ReqNotificationList): Resource<AppResponse<RespNotificationList>> {
        val response = makeAPICall(gson) {
            notificationApi.notificationList(model)
        }
        return response
    }

    override suspend fun seenNotification(notificationId: Int): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            notificationApi.seenNotification(notificationId)
        }
        return response
    }*/
}
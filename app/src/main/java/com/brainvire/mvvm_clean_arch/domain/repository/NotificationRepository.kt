package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource

interface NotificationRepository {
    suspend fun unreadNotificationCount(): Resource<AppResponse<Any>>

   /* suspend fun notificationList(model: ReqNotificationList): Resource<AppResponse<RespNotificationList>>
    suspend fun seenNotification(notificationId: Int): Resource<AppResponse<Any>>*/
}
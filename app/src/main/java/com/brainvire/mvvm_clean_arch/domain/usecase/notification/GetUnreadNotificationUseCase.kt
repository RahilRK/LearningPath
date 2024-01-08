package com.brainvire.mvvm_clean_arch.domain.usecase.notification

import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.domain.repository.NotificationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUnreadNotificationUseCase @Inject constructor(private val repository: NotificationRepository) {

    operator fun invoke(): Flow<Resource<AppResponse<Any>>> = flow {
        emit(Resource.Loading)
        val response = repository.unreadNotificationCount()
        emit(response)
    }
}
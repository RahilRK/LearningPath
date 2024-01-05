package com.brainvire.mvvm_clean_arch.data.model.response

sealed class Resource<out T>(val data: T? = null, val message: String? = null) {
    object Idle : Resource<Nothing>()
    object Loading : Resource<Nothing>()
    data class Success<T>(val successData: T) : Resource<T>(successData)
    data class Error<T>(
        val throwable: Throwable? = null,
        val errorMessage: String? = null,
        val messageCode: String? = null,
        val errorData: Any? = null,
        val errorCode: Int? = null,
        val responseData: T? = null,
        ) : Resource<Nothing>()
}

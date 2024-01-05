package com.brainvire.mvvm_clean_arch.presentation.shahen.login.state

import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.domain.model.Category
import com.shahen.provider.core.models.responses.login.RespLogin

data class LoginStateHandler(
    val data: AppResponse<RespLogin>? = null,
    val error: String = ""
)

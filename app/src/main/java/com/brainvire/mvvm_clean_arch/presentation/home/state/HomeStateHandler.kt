package com.brainvire.mvvm_clean_arch.presentation.home.state

import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import com.brainvire.mvvm_clean_arch.domain.model.Category

data class HomeStateHandler(
    val isLoading: Boolean = false,
    val data: List<Category?>? = null,
    val error: String = ""
)

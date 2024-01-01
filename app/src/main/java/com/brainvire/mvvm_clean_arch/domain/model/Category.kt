package com.brainvire.mvvm_clean_arch.domain.model

data class Category(
    var idCategory: String = "",
    var strCategory: String = "",
    var strCategoryThumb: String = "",
    var isSelected: Boolean = false
)
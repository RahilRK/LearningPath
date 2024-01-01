package com.brainvire.mvvm_clean_arch.data.model

import com.brainvire.mvvm_clean_arch.domain.model.Category

data class CategoryDTO(
    var idCategory: String = "",
    var strCategory: String = "",
    var strCategoryDescription: String = "",
    var strCategoryThumb: String = "",
    var isSelected: Boolean = false
)

fun CategoryDTO.toCategoryList(): Category {
    return Category(
        idCategory = this.idCategory?:"",
        strCategory = this.strCategory?:"",
        strCategoryThumb = this.strCategoryThumb,
    )
}
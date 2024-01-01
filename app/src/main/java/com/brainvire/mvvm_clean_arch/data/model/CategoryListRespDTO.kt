package com.brainvire.mvvm_clean_arch.data.model


import com.brainvire.mvvm_clean_arch.domain.model.Category
import com.google.gson.annotations.SerializedName

data class CategoryListRespDTO(
    @SerializedName("categories")
    val categories: List<CategoryRespDTO?>? = listOf()
) {
    data class CategoryRespDTO(
        @SerializedName("idCategory")
        val idCategory: String? = "", // 1
        @SerializedName("strCategory")
        val strCategory: String? = "", // Beef
        @SerializedName("strCategoryThumb")
        val strCategoryThumb: String? = "", // https://www.themealdb.com/images/category/beef.png
        @SerializedName("strCategoryDescription")
        val strCategoryDescription: String? = "" // Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]
    )
}

fun CategoryListRespDTO.CategoryRespDTO.toCategoryList(): Category {
    return Category(
        idCategory = this.idCategory?:"",
        strCategory = this.strCategory?:"",
        strCategoryThumb = this.strCategoryThumb?:"",
    )
}

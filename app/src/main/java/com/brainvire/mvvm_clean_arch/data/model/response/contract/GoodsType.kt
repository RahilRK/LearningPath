package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class GoodsType(
    @SerializedName("id")
    val id: Int? = null, // 4
    @SerializedName("bayan_id")
    val bayanId: Int? = null, // 4
    @SerializedName("name_ar")
    val nameAr: String? = null, // زراعية
    @SerializedName("name_en")
    val nameEn: String? = null, // Agricultural
    @SerializedName("parent_id")
    val parentId: Int? = null, // 0
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("sort_id")
    val sortId: Int? = null, // 5
    @SerializedName("created_at")
    val createdAt: String? = null, // 2022-01-23T11:47:19.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2022-12-29T06:04:37.000000Z
    @SerializedName("name")
    val name: String? = null // Agricultural
)
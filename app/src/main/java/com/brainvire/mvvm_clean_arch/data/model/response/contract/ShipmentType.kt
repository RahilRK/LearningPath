package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class ShipmentType(
    @SerializedName("id")
    val id: Int? = null, // 1
    @SerializedName("name_ar")
    val nameAr: String? = null, // محلي
    @SerializedName("name_en")
    val nameEn: String? = null, // Domestic
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("sort_id")
    val sortId: Int? = null, // 1
    @SerializedName("created_at")
    val createdAt: String? = null, // 2022-12-14T10:09:44.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2022-12-14T10:09:44.000000Z
    @SerializedName("name")
    val name: String? = null // Domestic
)
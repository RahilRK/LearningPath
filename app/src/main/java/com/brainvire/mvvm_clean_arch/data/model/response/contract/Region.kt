package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class Region(
    @SerializedName("id")
    val id: Int? = null, // 1
    @SerializedName("name_ar")
    val nameAr: String? = null, // منطقة الرياض
    @SerializedName("name_en")
    val nameEn: String? = null, // Riyadh
    @SerializedName("bayan_id")
    val bayanId: Int? = null, // 1
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("name")
    val name: String? = null // Riyadh
)
package com.brainvire.mvvm_clean_arch.data.model.response.direct_order.list

import com.google.gson.annotations.SerializedName

data class DistrictFromDetails(
    @SerializedName("id")
    val id: Int? = null, // 1
    @SerializedName("name_ar")
    val nameAr: String? = null, // District 1
    @SerializedName("name_en")
    val nameEn: String? = null, // Dis
    @SerializedName("city_id")
    val cityId: Int? = null, // 1
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("name")
    val name: String? = null // Dis
)
package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.brainvire.mvvm_clean_arch.data.model.response.contract.Region
import com.google.gson.annotations.SerializedName

data class CityFromDetails(
    @SerializedName("id")
    val id: Int? = null, // 2
    @SerializedName("region_id")
    val regionId: Int? = null, // 1
    @SerializedName("bayan_id")
    val bayanId: Int? = null, // 2
    @SerializedName("name_ar")
    val nameAr: String? = null, // الدرعية
    @SerializedName("name_en")
    val nameEn: String? = null, // ALDEREIAH
    @SerializedName("location")
    val location: String? = null, // 24.750173, 46.531952
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("name")
    val name: String? = null, // ALDEREIAH
    @SerializedName("latitude")
    val latitude: String? = null, // 24.750173
    @SerializedName("longitude")
    val longitude: String? = null, // 46.531952
    @SerializedName("region")
    val region: Region? = null
)
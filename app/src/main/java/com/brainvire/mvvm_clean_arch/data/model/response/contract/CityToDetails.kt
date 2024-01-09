package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class CityToDetails(
    @SerializedName("id")
    val id: Int? = 0, // 51
    @SerializedName("region_id")
    val regionId: Int? = 0, // 5
    @SerializedName("bayan_id")
    val bayanId: Int? = 0, // 51
    @SerializedName("name_ar")
    val nameAr: String? = "", // الدمام
    @SerializedName("name_en")
    val nameEn: String? = "", // DAMMAM
    @SerializedName("location")
    val location: String? = "", // 26.415391, 50.067395
    @SerializedName("active")
    val active: Int? = 0, // 1
    @SerializedName("name")
    val name: String? = "", // DAMMAM
    @SerializedName("latitude")
    val latitude: String? = "", // 26.415391
    @SerializedName("longitude")
    val longitude: String? = "", // 50.067395
    @SerializedName("region")
    val region: Region? = Region()
)
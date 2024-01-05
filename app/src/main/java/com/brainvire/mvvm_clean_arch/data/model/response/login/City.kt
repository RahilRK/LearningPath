package com.shahen.provider.core.models.responses.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("bayan_id")
    val bayanId: Int? = null, // 51
    @SerializedName("id")
    val id: Int? = null, // 51
    @SerializedName("latitude")
    val latitude: String? = null, // 26.415391
    @SerializedName("location")
    val location: String? = null, // 26.415391, 50.067395
    @SerializedName("longitude")
    val longitude: String? = null, // 50.067395
    @SerializedName("name")
    val name: String? = null, // DAMMAM
    @SerializedName("name_ar")
    val nameAr: String? = null, // الدمام
    @SerializedName("name_en")
    val nameEn: String? = null, // DAMMAM
    @SerializedName("region")
    val region: Region? = null,
    @SerializedName("region_id")
    val regionId: Int? = null // 5
) : Parcelable
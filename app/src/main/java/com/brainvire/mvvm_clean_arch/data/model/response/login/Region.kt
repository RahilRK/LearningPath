package com.shahen.provider.core.models.responses.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Region(
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("bayan_id")
    val bayanId: Int? = null, // 5
    @SerializedName("id")
    val id: Int? = null, // 5
    @SerializedName("name")
    val name: String? = null, // Eastern Province
    @SerializedName("name_ar")
    val nameAr: String? = null, // المنطقة الشرقية
    @SerializedName("name_en")
    val nameEn: String? = null // Eastern Province
) : Parcelable
package com.shahen.provider.core.models.responses.dashboard

import com.google.gson.annotations.SerializedName

data class Driver(
    @SerializedName("id")
    val id: Int? = null, // 158
    @SerializedName("provider_id")
    val providerId: Int? = null, // 78
    @SerializedName("name")
    val name: String? = null, // Dipti External Driver
    @SerializedName("profile_photo")
    val profilePhoto: String? = null, // 1_1696846259.jpg
    @SerializedName("national_id")
    val nationalId: String? = null, // 1072655168
    @SerializedName("mobile")
    val mobile: Any? = null, // null
    @SerializedName("absher_mobile")
    val absherMobile: String? = null, // 567892028
    @SerializedName("birthdate")
    val birthdate: String? = null, // 1991-05-10
    @SerializedName("birthdate_hijri")
    val birthdateHijri: Any? = null, // null
    @SerializedName("is_active")
    val isActive: Int? = null, // 1
    @SerializedName("created_at")
    val createdAt: String? = null, // 2023-10-18T15:25:01.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2023-10-18T15:25:01.000000Z
    @SerializedName("deleted_at")
    val deletedAt: Any? = null, // null
    @SerializedName("profile_photo_image")
    val profilePhotoImage: String? = null
)
package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class Truck(
    @SerializedName("id")
    val id: Int? = null, // 3
    @SerializedName("shipment_type_id")
    val shipmentTypeId: Int? = null, // 1
    @SerializedName("name_ar")
    val nameAr: String? = null, // ستارة
    @SerializedName("name_en")
    val nameEn: String? = null, // Curtain Side
    @SerializedName("image")
    val image: String? = null, // 51532310460520221222167169876599731.png
    @SerializedName("sort_id")
    val sortId: Int? = null, // 3
    @SerializedName("active")
    val active: Int? = null, // 1
    @SerializedName("created_at")
    val createdAt: String? = null, // 2022-12-22T05:46:05.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2022-12-22T05:46:05.000000Z
    @SerializedName("name")
    val name: String? = null, // Curtain Side
    @SerializedName("img_url")
    val imgUrl: String? = null, // https://shahennew.demo.brainvire.dev/storage/admin/51532310460520221222167169876599731.png
    @SerializedName("thumb_url")
    val thumbUrl: String? = null // https://shahennew.demo.brainvire.dev/thumbs/51532310460520221222167169876599731.png
)
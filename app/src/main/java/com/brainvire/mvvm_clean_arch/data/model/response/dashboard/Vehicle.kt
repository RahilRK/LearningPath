package com.shahen.provider.core.models.responses.dashboard

import com.brainvire.mvvm_clean_arch.data.model.response.contract.Truck
import com.google.gson.annotations.SerializedName

data class Vehicle(
    @SerializedName("id")
    val id: Int? = 0, // 119
    @SerializedName("provider_id")
    val providerId: Int? = 0, // 78
    @SerializedName("truck_id")
    val truckId: Int? = 0, // 3
    @SerializedName("plate_type_id")
    val plateTypeId: Int? = 0, // 3
    @SerializedName("plate_right_letter")
    val plateRightLetter: String? = "", // د
    @SerializedName("plate_left_letter")
    val plateLeftLetter: String? = "", // د
    @SerializedName("plate_middle_letter")
    val plateMiddleLetter: String? = "", // د
    @SerializedName("plate_number")
    val plateNumber: String? = "", // 7777
    @SerializedName("sequence_number")
    val sequenceNumber: String? = "", // 4397348798
    @SerializedName("is_active")
    val isActive: Int? = 0, // 1
    @SerializedName("created_at")
    val createdAt: String? = "", // 2023-10-04T10:43:09.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = "", // 2023-10-04T10:43:15.000000Z
    @SerializedName("deleted_at")
    val deletedAt: Any? = Any(), // null
    @SerializedName("full_plate_number")
    val fullPlateNumber: String? = "", // د د د 7777
    @SerializedName("truck")
    val truck: Truck? = Truck()
)
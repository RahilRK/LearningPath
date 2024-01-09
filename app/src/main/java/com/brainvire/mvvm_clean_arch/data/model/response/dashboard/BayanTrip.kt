package com.brainvire.mvvm_clean_arch.data.model.response.dashboard

import com.brainvire.mvvm_clean_arch.data.model.response.contract.StatusColor
import com.google.gson.annotations.SerializedName
import com.shahen.provider.core.models.responses.dashboard.Driver
import com.shahen.provider.core.models.responses.dashboard.Vehicle

data class BayanTrip(
    @SerializedName("id")
    val id: Int? = 0, // 121
    @SerializedName("order_id")
    val orderId: Int? = 0, // 427
    @SerializedName("trip_id")
    val tripId: Int? = 0, // 7547
    @SerializedName("waybill_id")
    val waybillId: Int? = 0, // 5191
    @SerializedName("vehicle_id")
    val vehicleId: Int? = 0, // 119
    @SerializedName("driver_id")
    val driverId: Int? = 0, // 158
    @SerializedName("extra_driver_id")
    val extraDriverId: Any? = Any(), // null
    @SerializedName("provider_id")
    val providerId: Int? = 0, // 78
    @SerializedName("status")
    val status: String? = "", // on_the_way_trip
    @SerializedName("wasl_trip_id")
    val waslTripId: String? = "", // 4f020960-5e70-403e-acc4-60f2ca987faf
    @SerializedName("dangerous_code")
    val dangerousCode: String? = "",
    @SerializedName("file")
    val `file`: Any? = Any(), // null
    @SerializedName("closed")
    val closed: Int? = 0, // 0
    @SerializedName("created_at")
    val createdAt: String? = "", // 2023-10-19T08:59:41.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = "", // 2023-10-19T09:00:37.000000Z
    @SerializedName("next_status")
    val nextStatus: String? = "", // at_unloading_location
    @SerializedName("orderStatus")
    val orderStatus: String? = "", // شحنة على الطريق
    @SerializedName("status_color")
    val statusColor: StatusColor? = StatusColor(),
    @SerializedName("vehicle")
    val vehicle: Vehicle? = Vehicle(),
    @SerializedName("driver")
    val driver: Driver? = Driver(),
    @SerializedName("extra_driver")
    val extraDriver: Any? = Any() // null
)
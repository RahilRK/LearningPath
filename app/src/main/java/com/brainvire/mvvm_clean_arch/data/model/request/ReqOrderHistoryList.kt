package com.brainvire.mvvm_clean_arch.data.model.request


import com.google.gson.annotations.SerializedName

data class ReqOrderHistoryList(
    @SerializedName("order_id")
    val orderId: String? = null,
    @SerializedName("trip_id")
    val tripId: String? = null,
    @SerializedName("truck_no")
    val truckNo: String? = null,
    @SerializedName("from_location")
    val fromLocation: String? = null,
    @SerializedName("to_location")
    val toLocation: String? = null,
    @SerializedName("p_type")
    val pType: String? = null, // new
    @SerializedName("section")
    val section: String? = null, // order
    @SerializedName("goods_type")
    val goodsType: Int? = null,
    @SerializedName("truck_type")
    val truckType: Int? = null,
    @SerializedName("date_from")
    val dateFrom: String? = null,
    @SerializedName("date_to")
    val dateTo: String? = null,
    @SerializedName("per_page")
    val perPage: Int? = null, // 10
    @SerializedName("page")
    val page: Int? = null, // 1,
    @SerializedName("search_text")
    val searchText: String? = null,
)
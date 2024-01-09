package com.brainvire.mvvm_clean_arch.data.model.response.dashboard

import com.brainvire.mvvm_clean_arch.data.model.response.contract.GoodsType
import com.brainvire.mvvm_clean_arch.data.model.response.contract.ShipmentType
import com.brainvire.mvvm_clean_arch.data.model.response.contract.StatusColor
import com.brainvire.mvvm_clean_arch.data.model.response.contract.Truck
import com.google.gson.annotations.SerializedName
import com.brainvire.mvvm_clean_arch.data.model.response.contract.CityFromDetails
import com.brainvire.mvvm_clean_arch.data.model.response.contract.CityToDetails
import com.brainvire.mvvm_clean_arch.data.model.response.contract.Provider
import com.brainvire.mvvm_clean_arch.data.model.response.contract.Requester

data class CurrentOrder(
    @SerializedName("id")
    val id: Int? = 0, // 427
    @SerializedName("section")
    val section: String? = "", // membership
    @SerializedName("delivery_type")
    val deliveryType: String? = "", // one_way
    @SerializedName("provider_id")
    val providerId: Int? = 0, // 78
    @SerializedName("requester_id")
    val requesterId: Int? = 0, // 111
    @SerializedName("description")
    val description: String? = "", // test desc
    @SerializedName("city_from")
    val cityFrom: Int? = 0, // 2
    @SerializedName("detail_address_from")
    val detailAddressFrom: String? = "", // abc xyz
    @SerializedName("city_to")
    val cityTo: Int? = 0, // 1
    @SerializedName("detail_address_to")
    val detailAddressTo: String? = "", // xyz suss
    @SerializedName("district_from")
    val districtFrom: Any? = Any(), // null
    @SerializedName("district_to")
    val districtTo: Any? = Any(), // null
    @SerializedName("lat_from")
    val latFrom: String? = "", // 24.774265
    @SerializedName("lng_from")
    val lngFrom: String? = "", // 46.738586
    @SerializedName("lat_to")
    val latTo: String? = "", // 24.774265
    @SerializedName("lng_to")
    val lngTo: String? = "", // 46.738586
    @SerializedName("shipment_date")
    val shipmentDate: String? = "", // 2023-12-27 00:00:00
    @SerializedName("offloading_date")
    val offloadingDate: String? = null, // null
    @SerializedName("shipment_type_id")
    val shipmentTypeId: Int? = 0, // 2
    @SerializedName("goods_type_id")
    val goodsTypeId: Int? = 0, // 2
    @SerializedName("goods_type_child_id")
    val goodsTypeChildId: Any? = Any(), // null
    @SerializedName("truck_id")
    val truckId: Int? = 0, // 2
    @SerializedName("quantity")
    val quantity: Int? = 0, // 5
    @SerializedName("weight")
    val weight: String? = "", // 1
    @SerializedName("status")
    val status: String? = "", // shipment_in_progress
    @SerializedName("paid")
    val paid: Int? = 0, // 0
    @SerializedName("payment_type")
    val paymentType: Any? = Any(), // null
    @SerializedName("payment_method")
    val paymentMethod: Any? = Any(), // null
    @SerializedName("price")
    val price: Int? = 0, // 340
    @SerializedName("vat_included")
    val vatIncluded: Int? = 0, // 1
    @SerializedName("vat_value")
    val vatValue: Double? = 0.0, // 255
    @SerializedName("offer_id")
    val offerId: Any? = Any(), // null
    @SerializedName("discount")
    val discount: Int? = 0, // 0
    @SerializedName("sub_total")
    val subTotal: Int? = 0, // 1700
    @SerializedName("shahen_profit_type")
    val shahenProfitType: String? = "", // fixed
    @SerializedName("shahen_profit_amount")
    val shahenProfitAmount: Int? = 0, // 0
    @SerializedName("total_price")
    val totalPrice: Double? = 0.0, // 1955
    @SerializedName("assign_provider_date")
    val assignProviderDate: String? = "", // 2023-10-19 10:54:09
    @SerializedName("price_details")
    val priceDetails: Any? = Any(), // null
    @SerializedName("vehicle_count")
    val vehicleCount: Int? = 0, // 5
    @SerializedName("odoo_invoice_status")
    val odooInvoiceStatus: String? = "", // Not Created
    @SerializedName("odoo_payment_status")
    val odooPaymentStatus: String? = "", // N/A
    @SerializedName("shahen_order")
    val shahenOrder: Int? = 0, // 1
    @SerializedName("created_at")
    val createdAt: String? = "", // 2023-10-19T08:54:09.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = "", // 2023-10-19T08:58:35.000000Z
    @SerializedName("status_text")
    val statusText: String? = "", // shipment in progress
    @SerializedName("next_status")
    val nextStatus: String? = "", // shipment_on_the_way
    @SerializedName("next_status_translation")
    val nextStatusTranslation: String? = "", // Order.shipment on the way
    @SerializedName("not_answered_from_provider")
    val notAnsweredFromProvider: Boolean? = false, // false
    @SerializedName("order_type")
    val orderType: String? = "", // شحنة من طلبات العقود
    @SerializedName("payment_method_icon")
    val paymentMethodIcon: String? = "",
    @SerializedName("payment_method_translate")
    val paymentMethodTranslate: String? = "",
    @SerializedName("download_pdf")
    val downloadPdf: String? = "",
    @SerializedName("invoice_preview_url")
    val invoicePreviewUrl: String? = "", // https://shahennew.demo.brainvire.dev/order/427/invoice?view=1
    @SerializedName("ago")
    val ago: String? = "", // منذ أسبوع
    @SerializedName("created_at_format")
    val createdAtFormat: String? = "", // 2023-10-19 10:54:09
    @SerializedName("delivery_type_translate")
    val deliveryTypeTranslate: String? = "", // ذهاب فقط
    @SerializedName("refused_comment")
    val refusedComment: String? = "",
    @SerializedName("price_item_details")
    val priceItemDetails: List<Any>? = listOf(),
    @SerializedName("status_color")
    val statusColor: StatusColor? = StatusColor(),
    @SerializedName("show_trips")
    val showTrips: Boolean? = false, // true
    @SerializedName("orderStatus")
    val orderStatus: String? = "", // الشحن قيد التقدم
    @SerializedName("sr_price")
    val srPrice: Int? = 0, // 0
    @SerializedName("district_from_details")
    val districtFromDetails: Any? = Any(), // null
    @SerializedName("district_to_details")
    val districtToDetails: Any? = Any(), // null
    @SerializedName("provider")
    val provider: Provider? = Provider(),
    @SerializedName("requester")
    val requester: Requester? = Requester(),
    @SerializedName("truck")
    val truck: Truck? = Truck(),
    @SerializedName("shipment_type")
    val shipmentType: ShipmentType? = ShipmentType(),
    @SerializedName("city_from_details")
    val cityFromDetails: CityFromDetails? = CityFromDetails(),
    @SerializedName("city_to_details")
    val cityToDetails: CityToDetails? = CityToDetails(),
    @SerializedName("goods_type")
    val goodsType: GoodsType? = GoodsType(),
    @SerializedName("bayan_trips")
    val bayanTrips: List<BayanTrip>? = listOf(),
    @SerializedName("offer")
    val offer: Any? = Any() // null
)
package com.brainvire.mvvm_clean_arch.data.model.response.order_history


import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.list.DistrictFromDetails
import com.google.gson.annotations.SerializedName
import com.shahen.provider.core.models.responses.login.City

data class RespOrderHistoryList(
    @SerializedName("current_page")
    val currentPage: Int? = 0, // 1
    @SerializedName("data")
    val `data`: List<Data>? = listOf(),
    @SerializedName("first_page_url")
    val firstPageUrl: String? = "", // https://shahennew.demo.brainvire.dev/api/provider/order/history?page=1
    @SerializedName("from")
    val from: Int? = 0, // 1
    @SerializedName("last_page")
    val lastPage: Int? = 0, // 10
    @SerializedName("last_page_url")
    val lastPageUrl: String? = "", // https://shahennew.demo.brainvire.dev/api/provider/order/history?page=10
    @SerializedName("links")
    val links: List<Link?>? = listOf(),
    @SerializedName("next_page_url")
    val nextPageUrl: String? = "", // https://shahennew.demo.brainvire.dev/api/provider/order/history?page=2
    @SerializedName("path")
    val path: String? = "", // https://shahennew.demo.brainvire.dev/api/provider/order/history
    @SerializedName("per_page")
    val perPage: Int? = 0, // 1
    @SerializedName("prev_page_url")
    val prevPageUrl: Any? = Any(), // null
    @SerializedName("to")
    val to: Int? = 0, // 1
    @SerializedName("total")
    val total: Int? = 0 // 10
) {
    data class Data(
        @SerializedName("id")
        val id: Int? = 0, // 385
        @SerializedName("section")
        val section: String? = "", // order
        @SerializedName("delivery_type")
        val deliveryType: String? = "", // one_way
        @SerializedName("provider_id")
        val providerId: Int? = 0, // 50
        @SerializedName("requester_id")
        val requesterId: Int? = 0, // 16
        @SerializedName("description")
        val description: String? = "", // sa
        @SerializedName("city_from")
        val cityFrom: Int? = 0, // 1
        @SerializedName("detail_address_from")
        val detailAddressFrom: String? = "", // Northern Ring Rd, Al Aqiq, Riyadh 13511, Saudi Arabia
        @SerializedName("city_to")
        val cityTo: Int? = 0, // 2
        @SerializedName("detail_address_to")
        val detailAddressTo: String? = "", // Northern Ring Rd, Al Aqiq, Riyadh 13511, Saudi Arabia
        @SerializedName("district_from")
        val districtFrom: Any? = Any(), // null
        @SerializedName("district_to")
        val districtTo: Any? = Any(), // null
        @SerializedName("lat_from")
        val latFrom: String? = "", // 24.7557387
        @SerializedName("lng_from")
        val lngFrom: String? = "", // 46.6302148
        @SerializedName("lat_to")
        val latTo: String? = "", // 24.7557387
        @SerializedName("lng_to")
        val lngTo: String? = "", // 46.6302148
        @SerializedName("shipment_date")
        val shipmentDate: String? = "", // 2023-10-19 00:00:00
        @SerializedName("offloading_date")
        val offloadingDate: String? = "", // null
        @SerializedName("shipment_type_id")
        val shipmentTypeId: Int? = 0, // 1
        @SerializedName("goods_type_id")
        val goodsTypeId: Int? = 0, // 4
        @SerializedName("goods_type_child_id")
        val goodsTypeChildId: Any? = Any(), // null
        @SerializedName("truck_id")
        val truckId: Int? = 0, // 5
        @SerializedName("quantity")
        val quantity: Int? = 0, // 2
        @SerializedName("weight")
        val weight: String? = "", // 2
        @SerializedName("status")
        val status: String? = "", // waiting_for_approval
        @SerializedName("paid")
        val paid: Int? = 0, // 0
        @SerializedName("payment_type")
        val paymentType: String? = "", // null
        @SerializedName("payment_method")
        val paymentMethod: String? = "", // null
        @SerializedName("price")
        val price: Int? = 0, // 100
        @SerializedName("vat_included")
        val vatIncluded: Int? = 0, // 1
        @SerializedName("vat_value")
        val vatValue: Double? = null, // 0
        @SerializedName("offer_id")
        val offerId: Any? = Any(), // null
        @SerializedName("discount")
        val discount: Int? = 0, // 0
        @SerializedName("sub_total")
        val subTotal: Int? = 0, // 200
        @SerializedName("shahen_profit")
        val shahenProfit: Int? = 0, // 0
        @SerializedName("shahen_profit_type")
        val shahenProfitType: String? = "", // fixed
        @SerializedName("shahen_profit_amount")
        val shahenProfitAmount: Int? = 0, // 0
        @SerializedName("total_price")
        val totalPrice: Double? = null, // 200
        @SerializedName("assign_provider_date")
        val assignProviderDate: String? = "", // 2023-10-13 16:29:29
        @SerializedName("price_details")
        val priceDetails: Double? = 0.0, // null
        @SerializedName("vehicle_count")
        val vehicleCount: Int? = 0, // Normal Shipment
        @SerializedName("odoo_invoice_status")
        val odooInvoiceStatus: String? = "", // Not Created
        @SerializedName("odoo_payment_status")
        val odooPaymentStatus: String? = "", // N/A
        @SerializedName("shahen_order")
        val shahenOrder: Int? = 0, // 0
        @SerializedName("created_at")
        val createdAt: String? = "", // 2023-10-13T14:29:23.000000Z
        @SerializedName("updated_at")
        val updatedAt: String? = "", // 2023-10-13T14:29:29.000000Z
        @SerializedName("status_text")
        val statusText: String? = "", // waiting for approval
        @SerializedName("next_status")
        val nextStatus: String? = "",
        @SerializedName("next_status_translation")
        val nextStatusTranslation: String? = "",
        @SerializedName("not_answered_from_provider")
        val notAnsweredFromProvider: Boolean? = false, // false
        @SerializedName("order_type")
        val orderType: String? = "", // Normal Shipment
        @SerializedName("payment_method_icon")
        val paymentMethodIcon: String? = "",
        @SerializedName("payment_method_translate")
        val paymentMethodTranslate: String? = "",
        @SerializedName("download_pdf")
        val downloadPdf: String? = "",
        @SerializedName("invoice_preview_url")
        val invoicePreviewUrl: String? = "", // https://shahennew.demo.brainvire.dev/order/385/invoice?view=1
        @SerializedName("ago")
        val ago: String? = "", // 5 days ago
        @SerializedName("created_at_format")
        val createdAtFormat: String? = "", // 2023-10-13 16:29:23
        @SerializedName("delivery_type_translate")
        val deliveryTypeTranslate: String? = "", // one way
        @SerializedName("refused_comment")
        val refusedComment: String? = "",
        @SerializedName("price_item_details")
        val priceItemDetails: List<Any?>? = listOf(),
        @SerializedName("status_color")
        val statusColor: StatusColor? = StatusColor(),
        @SerializedName("show_trips")
        val showTrips: Boolean? = false, // true
        @SerializedName("orderStatus")
        val orderStatus: String? = "", // New
        @SerializedName("sr_price")
        val srPrice: Int? = 0, // 0
        @SerializedName("sp_price")
        val spPrice: Double? = 0.0, // 0
        @SerializedName("district_from_details")
        val districtFromDetails: DistrictFromDetails? = DistrictFromDetails(),
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
        val bayanTrips: List<Any?>? = listOf(),
        @SerializedName("offer")
        val offer: Any? = Any() // null
    ) {
        data class StatusColor(
            @SerializedName("main")
            val main: String? = "", // blue
            @SerializedName("hex")
            val hex: String? = "" // #2C72B8
        )

        data class Provider(
            @SerializedName("id")
            val id: Int? = 0, // 50
            @SerializedName("type")
            val type: String? = "", // normal
            @SerializedName("user_id")
            val userId: Int? = 0, // 95
            @SerializedName("sp_number")
            val spNumber: Any? = Any(), // null
            @SerializedName("company_name")
            val companyName: String? = "", // test provider company
            @SerializedName("about")
            val about: String? = "", // testing
            @SerializedName("bio")
            val bio: String? = "", // null
            @SerializedName("region_id")
            val regionId: Any? = Any(), // null
            @SerializedName("city_id")
            val cityId: Int? = 0, // 0
            @SerializedName("latitude")
            val latitude: String? = null, // 23.0246556
            @SerializedName("longitude")
            val longitude: String? = null, // 72.5670114
            @SerializedName("detail_address")
            val detailAddress: Any? = Any(), // null
            @SerializedName("logo")
            val logo: String? = "", // 20732117091620220120164269135646823.jpg
            @SerializedName("commercial_registration")
            val commercialRegistration: String? = "", // Filename.jpg
            @SerializedName("commercial_registration_expire_date")
            val commercialRegistrationExpireDate: String? = "", // 2023-07-28
            @SerializedName("commercial_registration_expire_date_notify")
            val commercialRegistrationExpireDateNotify: Int? = 0, // 0
            @SerializedName("commercial_registration_expire_date_before_month_notify")
            val commercialRegistrationExpireDateBeforeMonthNotify: Int? = 0, // 0
            @SerializedName("vat_number")
            val vatNumber: String? = "", // 324321412345542
            @SerializedName("vat_certificate")
            val vatCertificate: String? = "", // Filename.jpg
            @SerializedName("tax_number")
            val taxNumber: String? = null, // 24198408531320230523168482119377458.jpeg
            @SerializedName("tax")
            val tax: String? = null, // 123456789009876
            @SerializedName("tax_expire_date")
            val taxExpireDate: Any? = Any(), // null
            @SerializedName("tax_expire_date_notify")
            val taxExpireDateNotify: Int? = 0, // 0
            @SerializedName("tax_expire_date_before_month_notify")
            val taxExpireDateBeforeMonthNotify: Int? = 0, // 0
            @SerializedName("address")
            val address: String? = null, // majosdsd
            @SerializedName("expiry_date_of_insurance_number")
            val expiryDateOfInsuranceNumber: String? = "", // 2023-07-29
            @SerializedName("insurance_certificate")
            val insuranceCertificate: String? = "", // Filename.jpg
            @SerializedName("fleet_number")
            val fleetNumber: String? = "", // 24
            @SerializedName("is_active")
            val isActive: Int? = 0, // 1
            @SerializedName("stop_service")
            val stopService: Int? = 0, // 0
            @SerializedName("status")
            val status: String? = "", // pending
            @SerializedName("absher_Id")
            val absherId: Any? = Any(), // null
            @SerializedName("moi")
            val moi: String? = null, // 7654345678
            @SerializedName("profit_amount_from_normal_shipments")
            val profitAmountFromNormalShipments: Int? = 0, // 0
            @SerializedName("profit_type_from_normal_shipments")
            val profitTypeFromNormalShipments: String? = "", // fixed
            @SerializedName("profit_amount_from_special_shipments")
            val profitAmountFromSpecialShipments: Int? = 0, // 0
            @SerializedName("profit_type_from_special_shipments")
            val profitTypeFromSpecialShipments: String? = "", // fixed
            @SerializedName("profit_amount_from_membership_contracts_shipments")
            val profitAmountFromMembershipContractsShipments: Int? = 0, // 0
            @SerializedName("profit_type_from_membership_contracts_shipments")
            val profitTypeFromMembershipContractsShipments: String? = "", // percentage
            @SerializedName("allow_logistics_requests")
            val allowLogisticsRequests: Int? = 0, // 0
            @SerializedName("created_at")
            val createdAt: String? = "", // 2023-07-26T10:20:03.000000Z
            @SerializedName("updated_at")
            val updatedAt: String? = "", // 2023-07-27T05:58:43.000000Z
            @SerializedName("logo_url")
            val logoUrl: String? = "", // https://shahennew.demo.brainvire.dev/storage/service_provider/20732117091620220120164269135646823.jpg
            @SerializedName("logo_thumb")
            val logoThumb: String? = "", // https://shahennew.demo.brainvire.dev/thumbs/20732117091620220120164269135646823.jpg
            @SerializedName("insurances")
            val insurances: String? = "",
            @SerializedName("full_address")
            val fullAddress: String? = "", //  -  - 
            @SerializedName("tax_number_image")
            val taxNumberImage: String? = "",
            @SerializedName("commercial_registration_image")
            val commercialRegistrationImage: String? = "", // https://shahennew.demo.brainvire.dev/storage/service_provider/Filename.jpg
            @SerializedName("is_expired_cards")
            val isExpiredCards: Boolean? = false, // true
            @SerializedName("expire_cards_less_than_or_equal_month")
            val expireCardsLessThanOrEqualMonth: Boolean? = false, // false
            @SerializedName("insurance_certificate_image")
            val insuranceCertificateImage: String? = "", // https://shahennew.demo.brainvire.dev/storage/service_provider/Filename.jpg
            @SerializedName("vat_certificate_image")
            val vatCertificateImage: String? = "", // https://shahennew.demo.brainvire.dev/storage/service_provider/Filename.jpg
            @SerializedName("city_from_details")
            val city: City? = City() // null
        )

        data class Requester(
            @SerializedName("id")
            val id: Int? = 0, // 16
            @SerializedName("first_name")
            val firstName: String? = "", // Abdul Nasir  S
            @SerializedName("last_name")
            val lastName: String? = "", // null
            @SerializedName("email")
            val email: String? = "", // shahen.requester@shahenexpress.com
            @SerializedName("mobile")
            val mobile: String? = "", // 535251926
            @SerializedName("email_verified_at")
            val emailVerifiedAt: String? = "", // 2023-01-30T06:47:44.000000Z
            @SerializedName("avatar")
            val avatar: Any? = Any(), // null
            @SerializedName("national_id")
            val nationalId: String? = "", // 0
            @SerializedName("requester_type")
            val requesterType: String? = "", // company
            @SerializedName("device_token")
            val deviceToken: String? = "", // dqS4SmBQ0UgWhGkKpjD-lt:APA91bEgo2O0Ew2_jboQ2Wkxh07THHI_gGZzkR49kuc0Z02SXiFB8OVH8Sn6nOZW5Sej-Fp0UllWjANCVhWXLMxEF59uKw-nY0yvrD6vfDpmNOfa-n-6KSAiE8CDlEJvbt7JkvuZvhJz
            @SerializedName("verification_code")
            val verificationCode: String? = "", // 2040
            @SerializedName("verification_updated_at")
            val verificationUpdatedAt: String? = "", // 2023-09-18 14:19:24
            @SerializedName("reset_code")
            val resetCode: Any? = Any(), // null
            @SerializedName("platform")
            val platform: String? = "", // ios
            @SerializedName("email_verified")
            val emailVerified: Int? = 0, // 1
            @SerializedName("absher_verified")
            val absherVerified: Int? = 0, // 1
            @SerializedName("absher_verification_updated_at")
            val absherVerificationUpdatedAt: String? = "", // 2023-01-30 08:43:21
            @SerializedName("absher_number")
            val absherNumber: Any? = Any(), // null
            @SerializedName("tax")
            val tax: String? = "", // 310285165400003
            @SerializedName("tax_image")
            val taxImage: Any? = Any(), // null
            @SerializedName("authorization_letter")
            val authorizationLetter: String? = "", // Uo2yB2vQHyTFYsLAbdul_Nasir_1696602265.pdf
            @SerializedName("authorization_person")
            val authorizationPerson: String? = "", // Guddus
            @SerializedName("insurance_expire_date")
            val insuranceExpireDate: Any? = Any(), // null
            @SerializedName("status")
            val status: String? = "", // activated
            @SerializedName("status_notes")
            val statusNotes: Any? = Any(), // null
            @SerializedName("reason")
            val reason: Any? = Any(), // null
            @SerializedName("is_completed")
            val isCompleted: Int? = 0, // 4
            @SerializedName("designation_id")
            val designationId: Any? = Any(), // null
            @SerializedName("employee_code")
            val employeeCode: String? = "", // SE00
            @SerializedName("created_by")
            val createdBy: Any? = Any(), // null
            @SerializedName("updated_by")
            val updatedBy: Any? = Any(), // null
            @SerializedName("bio")
            val bio: Any? = Any(), // null
            @SerializedName("created_at")
            val createdAt: String? = "", // 2023-01-30T06:40:49.000000Z
            @SerializedName("updated_at")
            val updatedAt: String? = "", // 2023-10-18T08:43:03.000000Z
            @SerializedName("name")
            val name: String? = "", // Abdul Nasir  S
            @SerializedName("avatar_url")
            val avatarUrl: String? = "",
            @SerializedName("avatar_thumb")
            val avatarThumb: String? = "",
            @SerializedName("img_url")
            val imgUrl: String? = "", // https://shahennew.demo.brainvire.dev/uploads/image_123650291_1697293679.jpg
            @SerializedName("thumb_url")
            val thumbUrl: String? = "", // https://shahennew.demo.brainvire.dev/thumbs/image_123650291_1697293679.jpg
            @SerializedName("tax_image_thumb")
            val taxImageThumb: String? = "",
            @SerializedName("status_message")
            val statusMessage: String? = "",
            @SerializedName("authorization_letter_url")
            val authorizationLetterUrl: String? = "", // https://shahennew.demo.brainvire.dev/storage/service_provider/Uo2yB2vQHyTFYsLAbdul_Nasir_1696602265.pdf
            @SerializedName("service_requester")
            val serviceRequester: ServiceRequester? = ServiceRequester()
        ) {
            data class ServiceRequester(
                @SerializedName("id")
                val id: Int? = 0, // 1
                @SerializedName("user_id")
                val userId: Int? = 0, // 16
                @SerializedName("sr_number")
                val srNumber: Any? = Any(), // null
                @SerializedName("company_name")
                val companyName: String? = "", // Riyadh
                @SerializedName("latitude")
                val latitude: Double? = 0.0, // 24.7557387
                @SerializedName("longitude")
                val longitude: Double? = 0.0, // 46.6302148
                @SerializedName("detail_address")
                val detailAddress: String? = "", // Northern Ring Rd, Al Aqiq, Riyadh 13511, Saudi Arabia
                @SerializedName("commercial_registration")
                val commercialRegistration: String? = "", // 6zPRq3VQd4CKPVNAbdul_Nasir_1696601813.jpg
                @SerializedName("commercial_registration_expire_date")
                val commercialRegistrationExpireDate: String? = "", // 2023-10-27
                @SerializedName("tax_number")
                val taxNumber: String? = "", // 68862817104920230130167509144954158.png
                @SerializedName("vat_number")
                val vatNumber: String? = "", // 235456246636462
                @SerializedName("vat_certificate")
                val vatCertificate: String? = "", // EEfW9vxqlxh2bFGAbdul_Nasir_1696602195.jpg
                @SerializedName("address")
                val address: String? = "", // Northern Ring Rd, Al Aqiq, Riyadh 13511, Saudi Arabia
                @SerializedName("region_id")
                val regionId: Any? = Any(), // null
                @SerializedName("city_id")
                val cityId: Any? = Any(), // null
                @SerializedName("logo")
                val logo: String? = "", // image_123650291_1697293679.jpg
                @SerializedName("absher_number")
                val absherNumber: Any? = Any(), // null
                @SerializedName("is_active")
                val isActive: Int? = 0, // 1
                @SerializedName("created_at")
                val createdAt: String? = "", // 2023-01-30T06:40:50.000000Z
                @SerializedName("updated_at")
                val updatedAt: String? = "", // 2023-10-14T14:28:15.000000Z
                @SerializedName("logo_url")
                val logoUrl: String? = "", // https://shahennew.demo.brainvire.dev/storage/service_provider/image_123650291_1697293679.jpg
                @SerializedName("logo_thumb")
                val logoThumb: String? = "", // https://shahennew.demo.brainvire.dev/thumbs/image_123650291_1697293679.jpg
                @SerializedName("commercial_registration_url")
                val commercialRegistrationUrl: String? = "", // https://shahennew.demo.brainvire.dev/storage/service_provider/6zPRq3VQd4CKPVNAbdul_Nasir_1696601813.jpg
                @SerializedName("tax_number_url")
                val taxNumberUrl: String? = "", // https://shahennew.demo.brainvire.dev/uploads/68862817104920230130167509144954158.png
                @SerializedName("vat_certificate_image")
                val vatCertificateImage: String? = "" // https://shahennew.demo.brainvire.dev/storage/service_provider/EEfW9vxqlxh2bFGAbdul_Nasir_1696602195.jpg
            )
        }

        data class Truck(
            @SerializedName("id")
            val id: Int? = 0, // 5
            @SerializedName("shipment_type_id")
            val shipmentTypeId: Int? = 0, // 1
            @SerializedName("name_ar")
            val nameAr: String? = "", // صندوق 40 قدم
            @SerializedName("name_en")
            val nameEn: String? = "", // Closed Box
            @SerializedName("image")
            val image: String? = "", // 23652010595520221222167169959597839.png
            @SerializedName("sort_id")
            val sortId: Int? = 0, // 5
            @SerializedName("active")
            val active: Int? = 0, // 1
            @SerializedName("created_at")
            val createdAt: String? = "", // 2022-12-22T05:59:55.000000Z
            @SerializedName("updated_at")
            val updatedAt: String? = "", // 2022-12-22T05:59:55.000000Z
            @SerializedName("name")
            val name: String? = "", // Closed Box
            @SerializedName("img_url")
            val imgUrl: String? = "", // https://shahennew.demo.brainvire.dev/storage/admin/23652010595520221222167169959597839.png
            @SerializedName("thumb_url")
            val thumbUrl: String? = "" // https://shahennew.demo.brainvire.dev/thumbs/23652010595520221222167169959597839.png
        )

        data class ShipmentType(
            @SerializedName("id")
            val id: Int? = 0, // 1
            @SerializedName("name_ar")
            val nameAr: String? = "", // محلي
            @SerializedName("name_en")
            val nameEn: String? = "", // Domestic
            @SerializedName("active")
            val active: Int? = 0, // 1
            @SerializedName("sort_id")
            val sortId: Int? = 0, // 1
            @SerializedName("created_at")
            val createdAt: String? = "", // 2022-12-14T10:09:44.000000Z
            @SerializedName("updated_at")
            val updatedAt: String? = "", // 2022-12-14T10:09:44.000000Z
            @SerializedName("name")
            val name: String? = "" // Domestic
        )

        data class CityFromDetails(
            @SerializedName("id")
            val id: Int? = 0, // 1
            @SerializedName("region_id")
            val regionId: Int? = 0, // 1
            @SerializedName("bayan_id")
            val bayanId: Int? = 0, // 1
            @SerializedName("name_ar")
            val nameAr: String? = "", // الرياض
            @SerializedName("name_en")
            val nameEn: String? = "", // RIYADH
            @SerializedName("location")
            val location: String? = "", // 24.726400, 46.671542
            @SerializedName("active")
            val active: Int? = 0, // 1
            @SerializedName("name")
            val name: String? = "", // RIYADH
            @SerializedName("latitude")
            val latitude: String? = "", // 24.726400
            @SerializedName("longitude")
            val longitude: String? = "", // 46.671542
            @SerializedName("region")
            val region: Region? = Region()
        ) {
            data class Region(
                @SerializedName("id")
                val id: Int? = 0, // 1
                @SerializedName("name_ar")
                val nameAr: String? = "", // منطقة الرياض
                @SerializedName("name_en")
                val nameEn: String? = "", // Riyadh
                @SerializedName("bayan_id")
                val bayanId: Int? = 0, // 1
                @SerializedName("active")
                val active: Int? = 0, // 1
                @SerializedName("name")
                val name: String? = "" // Riyadh
            )
        }

        data class CityToDetails(
            @SerializedName("id")
            val id: Int? = 0, // 2
            @SerializedName("region_id")
            val regionId: Int? = 0, // 1
            @SerializedName("bayan_id")
            val bayanId: Int? = 0, // 2
            @SerializedName("name_ar")
            val nameAr: String? = "", // الدرعية
            @SerializedName("name_en")
            val nameEn: String? = "", // ALDEREIAH
            @SerializedName("location")
            val location: String? = "", // 24.750173, 46.531952
            @SerializedName("active")
            val active: Int? = 0, // 1
            @SerializedName("name")
            val name: String? = "", // ALDEREIAH
            @SerializedName("latitude")
            val latitude: String? = "", // 24.750173
            @SerializedName("longitude")
            val longitude: String? = "", // 46.531952
            @SerializedName("region")
            val region: Region? = Region()
        ) {
            data class Region(
                @SerializedName("id")
                val id: Int? = 0, // 1
                @SerializedName("name_ar")
                val nameAr: String? = "", // منطقة الرياض
                @SerializedName("name_en")
                val nameEn: String? = "", // Riyadh
                @SerializedName("bayan_id")
                val bayanId: Int? = 0, // 1
                @SerializedName("active")
                val active: Int? = 0, // 1
                @SerializedName("name")
                val name: String? = "" // Riyadh
            )
        }

        data class GoodsType(
            @SerializedName("id")
            val id: Int? = 0, // 4
            @SerializedName("bayan_id")
            val bayanId: Int? = 0, // 4
            @SerializedName("name_ar")
            val nameAr: String? = "", // زراعية
            @SerializedName("name_en")
            val nameEn: String? = "", // Agricultural
            @SerializedName("parent_id")
            val parentId: Int? = 0, // 0
            @SerializedName("active")
            val active: Int? = 0, // 1
            @SerializedName("sort_id")
            val sortId: Int? = 0, // 5
            @SerializedName("created_at")
            val createdAt: String? = "", // 2022-01-23T11:47:19.000000Z
            @SerializedName("updated_at")
            val updatedAt: String? = "", // 2022-12-29T06:04:37.000000Z
            @SerializedName("name")
            val name: String? = "" // Agricultural
        )
    }

    data class Link(
        @SerializedName("url")
        val url: String? = "", // https://shahennew.demo.brainvire.dev/api/provider/order/history?page=1
        @SerializedName("label")
        val label: String? = "", // &laquo; Previous
        @SerializedName("active")
        val active: Boolean? = false // false
    )
}
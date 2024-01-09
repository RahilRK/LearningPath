package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class Provider(
    @SerializedName("id")
    val id: Int? = null, // 78
    @SerializedName("type")
    val type: String? = null, // normal
    @SerializedName("user_id")
    val userId: Int? = null, // 157
    @SerializedName("company_name")
    val companyName: String? = null, // Brainvire info
    @SerializedName("about")
    val about: Any? = null, // null
    @SerializedName("bio")
    val bio: String? = null, // About info
    @SerializedName("region_id")
    val regionId: Any? = null, // null
    @SerializedName("city_id")
    val cityId: Int? = null, // 0
    @SerializedName("latitude")
    val latitude: String? = null, // 23.22347199
    @SerializedName("longitude")
    val longitude: String? = null, // 72.61506982
    @SerializedName("detail_address")
    val detailAddress: Any? = null, // null
    @SerializedName("logo")
    val logo: String? = null, // 20732117091620220120164269135646823.jpg
    @SerializedName("commercial_registration")
    val commercialRegistration: String? = null, // Filename.jpg
    @SerializedName("commercial_registration_expire_date")
    val commercialRegistrationExpireDate: String? = null, // 2024-01-01
    @SerializedName("commercial_registration_expire_date_notify")
    val commercialRegistrationExpireDateNotify: Int? = null, // 0
    @SerializedName("commercial_registration_expire_date_before_month_notify")
    val commercialRegistrationExpireDateBeforeMonthNotify: Int? = null, // 0
    @SerializedName("vat_number")
    val vatNumber: String? = null, // 712345678123451
    @SerializedName("vat_certificate")
    val vatCertificate: String? = null, // Filename.jpg
    @SerializedName("tax_number")
    val taxNumber: Any? = null, // null
    @SerializedName("tax")
    val tax: Any? = null, // null
    @SerializedName("tax_expire_date")
    val taxExpireDate: Any? = null, // null
    @SerializedName("tax_expire_date_notify")
    val taxExpireDateNotify: Int? = null, // 0
    @SerializedName("tax_expire_date_before_month_notify")
    val taxExpireDateBeforeMonthNotify: Int? = null, // 0
    @SerializedName("address")
    val address: String? = null, // BLOCK-F, BLUE BELLS EXOTICA, Gujarat 382016, India
    @SerializedName("expiry_date_of_insurance_number")
    val expiryDateOfInsuranceNumber: String? = null, // 2024-01-01
    @SerializedName("insurance_certificate")
    val insuranceCertificate: String? = null, // Filename.jpg
    @SerializedName("fleet_number")
    val fleetNumber: String? = null, // 1
    @SerializedName("is_active")
    val isActive: Int? = null, // 1
    @SerializedName("stop_service")
    val stopService: Int? = null, // 0
    @SerializedName("status")
    val status: String? = null, // pending
    @SerializedName("absher_Id")
    val absherId: Any? = null, // null
    @SerializedName("moi")
    val moi: String? = null, // 7891234821
    @SerializedName("profit_amount_from_normal_shipments")
    val profitAmountFromNormalShipments: Int? = null, // 0
    @SerializedName("profit_type_from_normal_shipments")
    val profitTypeFromNormalShipments: String? = null, // fixed
    @SerializedName("profit_amount_from_special_shipments")
    val profitAmountFromSpecialShipments: Int? = null, // 0
    @SerializedName("profit_type_from_special_shipments")
    val profitTypeFromSpecialShipments: String? = null, // fixed
    @SerializedName("profit_amount_from_membership_contracts_shipments")
    val profitAmountFromMembershipContractsShipments: Int? = null, // 0
    @SerializedName("profit_type_from_membership_contracts_shipments")
    val profitTypeFromMembershipContractsShipments: String? = null, // percentage
    @SerializedName("allow_logistics_requests")
    val allowLogisticsRequests: Int? = null, // 0
    @SerializedName("created_at")
    val createdAt: String? = null, // 2023-08-03T10:25:05.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2023-08-10T12:45:02.000000Z
    @SerializedName("logo_url")
    val logoUrl: String? = null, // https://shahennew.demo.brainvire.dev/storage/service_provider/20732117091620220120164269135646823.jpg
    @SerializedName("logo_thumb")
    val logoThumb: String? = null, // https://shahennew.demo.brainvire.dev/thumbs/20732117091620220120164269135646823.jpg
    @SerializedName("insurances")
    val insurances: String? = null,
    @SerializedName("full_address")
    val fullAddress: String? = null, //  -  - BLOCK-F, BLUE BELLS EXOTICA, Gujarat 382016, India
    @SerializedName("tax_number_image")
    val taxNumberImage: String? = null,
    @SerializedName("commercial_registration_image")
    val commercialRegistrationImage: String? = null, // https://shahennew.demo.brainvire.dev/storage/service_provider/Filename.jpg
    @SerializedName("is_expired_cards")
    val isExpiredCards: Boolean? = null, // false
    @SerializedName("expire_cards_less_than_or_equal_month")
    val expireCardsLessThanOrEqualMonth: Boolean? = null, // true
    @SerializedName("insurance_certificate_image")
    val insuranceCertificateImage: String? = null, // https://shahennew.demo.brainvire.dev/storage/service_provider/Filename.jpg
    @SerializedName("vat_certificate_image")
    val vatCertificateImage: String? = null, // https://shahennew.demo.brainvire.dev/storage/service_provider/Filename.jpg
    @SerializedName("city")
    val city: Any? = null // null
)
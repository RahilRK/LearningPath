package com.shahen.provider.core.models.responses.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServiceProvider(
    @SerializedName("about")
    val about: String? = null, // null
    @SerializedName("bio")
    val bio: String? = null, // null
    @SerializedName("absher_Id")
    val absherId: Int? = null, // null
    @SerializedName("address")
    val address: String? = null, // 1 street
    @SerializedName("allow_logistics_requests")
    val allowLogisticsRequests: Int? = null, // 0
    @SerializedName("city_id")
    val cityId: Int? = null, // 51
    @SerializedName("commercial_registration")
    var commercialRegistration: String? = null, // 19279508571020230410168110983024012.png
    @SerializedName("commercial_registration_expire_date")
    val commercialRegistrationExpireDate: String? = null, // 2024-01-10
    @SerializedName("commercial_registration_expire_date_before_month_notify")
    val commercialRegistrationExpireDateBeforeMonthNotify: Int? = null, // 0
    @SerializedName("commercial_registration_expire_date_notify")
    val commercialRegistrationExpireDateNotify: Int? = null, // 0
    @SerializedName("commercial_registration_image")
    var commercialRegistrationImage: String? = null, // https://shahennew.demo.brainvire.dev/uploads/19279508571020230410168110983024012.png
    @SerializedName("company_name")
    val companyName: String? = null, // Shahen SP
    @SerializedName("created_at")
    val createdAt: String? = null, // 2023-04-10T06:57:11.000000Z
    @SerializedName("expire_cards_less_than_or_equal_month")
    val expireCardsLessThanOrEqualMonth: Boolean? = null, // true
    @SerializedName("expiry_date_of_insurance_number")
    val expiryDateOfInsuranceNumber: String? = null, // 2024-02-02
    @SerializedName("fleet_number")
    val fleetNumber: String? = null, // 125
    @SerializedName("full_address")
    val fullAddress: String? = null, // Eastern Province - DAMMAM - 1 street
    @SerializedName("id")
    val id: Int? = null, // 6
    @SerializedName("insurance_certificate")
    var insuranceCertificate: String? = null, // 82225108571020230410168110983032195.png
    @SerializedName("insurance_certificate_image")
    var insuranceCertificateImage: String? = null, // https://shahennew.demo.brainvire.dev/uploads/82225108571020230410168110983032195.png
    @SerializedName("insurances")
    val insurances: String? = null,
    @SerializedName("is_active")
    val isActive: Int? = null, // 1
    @SerializedName("is_expired_cards")
    val isExpiredCards: Boolean? = null, // false
    @SerializedName("latitude")
    var latitude: Double? = 0.0, // 26.407209
    @SerializedName("logo")
    val logo: String? = null, // 44378208571020230410168110983063124.png
    @SerializedName("logo_thumb")
    val logoThumb: String? = null, // https://shahennew.demo.brainvire.dev/thumbs/44378208571020230410168110983063124.png
    @SerializedName("logo_url")
    val logoUrl: String? = null, // https://shahennew.demo.brainvire.dev/uploads/44378208571020230410168110983063124.png
    @SerializedName("longitude")
    var longitude: Double? = 0.0, // 50.137985
    @SerializedName("moi")
    val moi: String? = null, // 7000123456
    @SerializedName("profit_amount_from_membership_contracts_shipments")
    val profitAmountFromMembershipContractsShipments: Int? = null, // 10
    @SerializedName("profit_amount_from_normal_shipments")
    val profitAmountFromNormalShipments: Int? = null, // 10
    @SerializedName("profit_amount_from_special_shipments")
    val profitAmountFromSpecialShipments: Int? = null, // 10
    @SerializedName("profit_type_from_membership_contracts_shipments")
    val profitTypeFromMembershipContractsShipments: String? = null, // percentage
    @SerializedName("profit_type_from_normal_shipments")
    val profitTypeFromNormalShipments: String? = null, // percentage
    @SerializedName("profit_type_from_special_shipments")
    val profitTypeFromSpecialShipments: String? = null, // percentage
    @SerializedName("region_id")
    val regionId: Int? = null, // 5
    @SerializedName("status")
    val status: String? = null, // pending
    @SerializedName("stop_service")
    val stopService: Int? = null, // 0
    @SerializedName("tax")
    val tax: String? = null, // 310285165400003
    @SerializedName("tax_expire_date")
    val taxExpireDate: String? = null, // null
    @SerializedName("tax_expire_date_before_month_notify")
    val taxExpireDateBeforeMonthNotify: Int? = null, // 0
    @SerializedName("tax_expire_date_notify")
    val taxExpireDateNotify: Int? = null, // 0
    @SerializedName("tax_number")
    val taxNumber: String? = null, // 73456808571020230410168110983046613.png
    @SerializedName("tax_number_image")
    val taxNumberImage: String? = null, // https://shahennew.demo.brainvire.dev/uploads/73456808571020230410168110983046613.png
    @SerializedName("type")
    val type: String? = null, // normal
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2023-04-10T06:57:11.000000Z
    @SerializedName("user_id")
    val userId: Int? = null, // 15
    @SerializedName("vat_certificate")
    var vatCertificate: String? = null,
    @SerializedName("vat_certificate_image")
    var vatCertificateImage: String? = null,
    @SerializedName("vat_number")
    val vatNumber: String? = null, // null
    @SerializedName("street_name")
    val streetName: String? = null, // test
    @SerializedName("additional_street_name")
    val additionalStreetName: String? = null,
    @SerializedName("address_line1_ar")
    val addressLine1Ar: String? = null,
    @SerializedName("address_line2_ar")
    val addressLine2Ar: String? = null,
    @SerializedName("building_number")
    val buildingNumber: String? = null, // 123
    @SerializedName("floor_no")
    val floorNo: String? = null,
    @SerializedName("province")
    val province: String? = null,
    @SerializedName("postal_code")
    val postalCode: String? = null, // 123
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("country")
    val country: String? = null, // test
    @SerializedName("aditional_address_attribuite")
    val aditionalAddressAttribuite: String? = null, // 123
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("mot_number")
    val motNumber: String? = null,
    @SerializedName("mot_license_url")
    var motLicenseUrl: String? = null,
    @SerializedName("mot_license")
    var motLicense: String? = null,
) : Parcelable
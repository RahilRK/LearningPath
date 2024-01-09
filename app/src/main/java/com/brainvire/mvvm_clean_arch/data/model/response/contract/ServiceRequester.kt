package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class ServiceRequester(
    @SerializedName("id")
    val id: Int? = null, // 1
    @SerializedName("user_id")
    val userId: Int? = null, // 16
    @SerializedName("company_name")
    val companyName: String? = null, // Abdul Trading
    @SerializedName("latitude")
    val latitude: Double? = null, // 21.41687726
    @SerializedName("longitude")
    val longitude: Double? = null, // 39.82258055
    @SerializedName("detail_address")
    val detailAddress: Any? = null, // null
    @SerializedName("commercial_registration")
    val commercialRegistration: String? = null, // 351A85F8-CE09-4074-9BA9-84D5B3591725.jpeg
    @SerializedName("commercial_registration_expire_date")
    val commercialRegistrationExpireDate: String? = null, // 2023-09-28
    @SerializedName("tax_number")
    val taxNumber: String? = null, // 68862817104920230130167509144954158.png
    @SerializedName("vat_number")
    val vatNumber: String? = null, // 235456246636462
    @SerializedName("vat_certificate")
    val vatCertificate: String? = null, // sample.pdf
    @SerializedName("address")
    val address: String? = null, // MASB6624, 6624 Ibrahim Al Khalil Rd, 3914, Al Hajlah, Makkah 24231, Saudi Arabia
    @SerializedName("region_id")
    val regionId: Any? = null, // null
    @SerializedName("city_id")
    val cityId: Any? = null, // null
    @SerializedName("logo")
    val logo: String? = null, // 91182317201520230130167509201555190.png
    @SerializedName("absher_number")
    val absherNumber: Any? = null, // null
    @SerializedName("is_active")
    val isActive: Int? = null, // 1
    @SerializedName("created_at")
    val createdAt: String? = null, // 2023-01-30T06:40:50.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2023-09-27T08:16:11.000000Z
    @SerializedName("logo_url")
    val logoUrl: String? = null, // https://shahennew.demo.brainvire.dev/storage/service_provider/91182317201520230130167509201555190.png
    @SerializedName("logo_thumb")
    val logoThumb: String? = null, // https://shahennew.demo.brainvire.dev/thumbs/91182317201520230130167509201555190.png
    @SerializedName("commercial_registration_url")
    val commercialRegistrationUrl: String? = null, // https://shahennew.demo.brainvire.dev/storage/service_provider/351A85F8-CE09-4074-9BA9-84D5B3591725.jpeg
    @SerializedName("tax_number_url")
    val taxNumberUrl: String? = null, // https://shahennew.demo.brainvire.dev/uploads/68862817104920230130167509144954158.png
    @SerializedName("vat_certificate_image")
    val vatCertificateImage: String? = null // https://shahennew.demo.brainvire.dev/storage/service_provider/sample.pdf
)
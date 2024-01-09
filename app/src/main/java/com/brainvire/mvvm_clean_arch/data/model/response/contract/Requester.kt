package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.brainvire.mvvm_clean_arch.data.model.response.contract.ServiceRequester
import com.google.gson.annotations.SerializedName

data class Requester(
    @SerializedName("id")
    val id: Int? = null, // 16
    @SerializedName("first_name")
    val firstName: String? = null, // Abdul Nasir  S
    @SerializedName("last_name")
    val lastName: Any? = null, // null
    @SerializedName("email")
    val email: String? = null, // shahen.requester@shahenexpress.com
    @SerializedName("mobile")
    val mobile: String? = null, // 535251926
    @SerializedName("email_verified_at")
    val emailVerifiedAt: String? = null, // 2023-01-30T06:47:44.000000Z
    @SerializedName("avatar")
    val avatar: Any? = null, // null
    @SerializedName("national_id")
    val nationalId: String? = null, // 1
    @SerializedName("requester_type")
    val requesterType: String? = null, // company
    @SerializedName("device_token")
    val deviceToken: String? = null, // chr5_EBlvkCipMICqPS_Yx:APA91bHxk3kb_BqZrEofDJO7fqx1OrIbnWaheLdW9GwFCjHmt8NGDYBz4AyVY7-XmtlK7C0ZnimIIhTpQ63r0kzmMTJ1M35k0xH_5Bq3cuQILEwzSaNAYVF0VUDfB2l4mSIzAL4_5LKw
    @SerializedName("verification_code")
    val verificationCode: String? = null, // 2040
    @SerializedName("verification_updated_at")
    val verificationUpdatedAt: String? = null, // 2023-09-18 14:19:24
    @SerializedName("reset_code")
    val resetCode: Any? = null, // null
    @SerializedName("platform")
    val platform: String? = null, // ios
    @SerializedName("email_verified")
    val emailVerified: Int? = null, // 1
    @SerializedName("absher_verified")
    val absherVerified: Int? = null, // 1
    @SerializedName("absher_verification_updated_at")
    val absherVerificationUpdatedAt: String? = null, // 2023-01-30 08:43:21
    @SerializedName("absher_number")
    val absherNumber: Any? = null, // null
    @SerializedName("tax")
    val tax: String? = null, // 310285165400003
    @SerializedName("tax_image")
    val taxImage: Any? = null, // null
    @SerializedName("authorization_letter")
    val authorizationLetter: String? = null, // 2AC7B975-1841-4FB3-84E7-3239EEE89155.jpeg
    @SerializedName("authorization_person")
    val authorizationPerson: String? = null, // Abdul Nasir
    @SerializedName("insurance_expire_date")
    val insuranceExpireDate: Any? = null, // null
    @SerializedName("status")
    val status: String? = null, // activated
    @SerializedName("status_notes")
    val statusNotes: Any? = null, // null
    @SerializedName("reason")
    val reason: Any? = null, // null
    @SerializedName("is_completed")
    val isCompleted: Int? = null, // 4
    @SerializedName("designation_id")
    val designationId: Any? = null, // null
    @SerializedName("employee_code")
    val employeeCode: String? = null, // SE00
    @SerializedName("created_by")
    val createdBy: Any? = null, // null
    @SerializedName("updated_by")
    val updatedBy: Any? = null, // null
    @SerializedName("bio")
    val bio: Any? = null, // null
    @SerializedName("created_at")
    val createdAt: String? = null, // 2023-01-30T06:40:49.000000Z
    @SerializedName("updated_at")
    val updatedAt: String? = null, // 2023-09-28T08:30:41.000000Z
    @SerializedName("name")
    val name: String? = null, // Abdul Nasir  S
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("avatar_thumb")
    val avatarThumb: String? = null,
    @SerializedName("img_url")
    val imgUrl: String? = null, // https://shahennew.demo.brainvire.dev/uploads/91182317201520230130167509201555190.png
    @SerializedName("thumb_url")
    val thumbUrl: String? = null, // https://shahennew.demo.brainvire.dev/thumbs/91182317201520230130167509201555190.png
    @SerializedName("tax_image_thumb")
    val taxImageThumb: String? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null,
    @SerializedName("authorization_letter_url")
    val authorizationLetterUrl: String? = null, // https://shahennew.demo.brainvire.dev/storage/service_provider/2AC7B975-1841-4FB3-84E7-3239EEE89155.jpeg
    @SerializedName("service_requester")
    val serviceRequester: ServiceRequester? = null
)
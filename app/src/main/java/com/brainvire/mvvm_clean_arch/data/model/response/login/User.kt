package com.shahen.provider.core.models.responses.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("absher_number")
    val absherNumber: String? = null, // null
    @SerializedName("absher_verification_updated_at")
    val absherVerificationUpdatedAt: String? = "", // 2023-06-15 12:59:26
    @SerializedName("absher_verified")
    val absherVerified: Int? = 0, // 1
    @SerializedName("authorization_letter")
    var authorizationLetter: String? = "", // 1681109829.pdf
    @SerializedName("authorization_letter_url")
    var authorizationLetterUrl: String? = "", // https://shahennew.demo.brainvire.dev/uploads/files/1681109829.pdf
    @SerializedName("authorization_person")
    val authorizationPerson: String? = "", // Adnan
    @SerializedName("avatar")
    val avatar: String? = null, // null
    @SerializedName("avatar_thumb")
    val avatarThumb: String? = "",
    @SerializedName("avatar_url")
    val avatarUrl: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = "", // 2023-04-10T06:57:09.000000Z
    @SerializedName("device_token")
    val deviceToken: String? = "",
    @SerializedName("email")
    val email: String? = "", // shahen.provider@shahenexpress.com
    @SerializedName("email_verified")
    val emailVerified: Int? = 0, // 1
    @SerializedName("email_verified_at")
    val emailVerifiedAt: String? = "", // 2023-06-15T10:56:01.000000Z
    @SerializedName("first_name")
    val firstName: String? = "", // adnan
    @SerializedName("id")
    val id: Int? = null, // 15
    @SerializedName("img_url")
    val imgUrl: String? = "", // https://shahennew.demo.brainvire.dev/uploads/44378208571020230410168110983063124.png
    @SerializedName("insurance_expire_date")
    val insuranceExpireDate: String? = null, // null
    @SerializedName("is_completed")
    val isCompleted: Int? = 0, // 4
    @SerializedName("last_name")
    val lastName: String? = null, // null
    @SerializedName("mobile")
    val mobile: String? = "", // 0582089345
    @SerializedName("name")
    val name: String? = "", // adnan
    @SerializedName("national_id")
    val nationalId: String? = "", // 1029856372
    @SerializedName("platform")
    val platform: String? = null, // null
    @SerializedName("requester_type")
    val requesterType: String? = null, // null
    @SerializedName("reset_code")
    val resetCode: String? = null, // null
    @SerializedName("roles")
    val roles: List<Role>? = listOf(),
    @SerializedName("service_provider")
    val serviceProvider: ServiceProvider? = ServiceProvider(),
    @SerializedName("status")
    val status: String? = "", // activated
    @SerializedName("status_message")
    val statusMessage: String? = "",
    @SerializedName("status_notes")
    val statusNotes: String? = null, // null
    @SerializedName("tax")
    val tax: String? = null, // null
    @SerializedName("tax_image")
    val taxImage: String? = null, // null
    @SerializedName("tax_image_thumb")
    val taxImageThumb: String? = "",
    @SerializedName("thumb_url")
    val thumbUrl: String? = "", // https://shahennew.demo.brainvire.dev/thumbs/44378208571020230410168110983063124.png
    @SerializedName("updated_at")
    val updatedAt: String? = "", // 2023-06-15T10:59:26.000000Z
    @SerializedName("verification_code")
    val verificationCode: String? = "", // 8032
    @SerializedName("verification_updated_at")
    val verificationUpdatedAt: String? = null, // null
    @SerializedName("notification_count")
    val notificationCount: Int? = 0,
) : Parcelable
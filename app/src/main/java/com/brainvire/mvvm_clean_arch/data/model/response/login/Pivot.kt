package com.shahen.provider.core.models.responses.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pivot(
    @SerializedName("role_id")
    val roleId: Int? = null, // 3
    @SerializedName("user_id")
    val userId: Int? = null, // 15
    @SerializedName("user_type")
    val userType: String? = null // App\Models\User
) : Parcelable
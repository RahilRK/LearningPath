package com.shahen.provider.core.models.responses.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Role(
    @SerializedName("created_at")
    val createdAt: String? = "", // 2020-11-26T03:30:00.000000Z
    @SerializedName("description")
    val description: String? = "", // Service Provider
    @SerializedName("display_name")
    val displayName: String? = "", // Service Provider
    @SerializedName("guard")
    val guard: String? = "", // web
    @SerializedName("id")
    val id: Int? = 0, // 3
    @SerializedName("main")
    val main: Int? = 0, // 1
    @SerializedName("name")
    val name: String? = "", // service_provider
    @SerializedName("pivot")
    val pivot: Pivot? = Pivot(),
    @SerializedName("updated_at")
    val updatedAt: String? = "" // 2020-11-26T03:30:00.000000Z
) : Parcelable
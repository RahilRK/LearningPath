package com.brainvire.mvvm_clean_arch.data.model.request

import com.google.gson.annotations.SerializedName

data class ReqDirectOrderDashboard(
    @SerializedName("section")
    val section: String? = null //'order', 'special_order', 'membership'
)
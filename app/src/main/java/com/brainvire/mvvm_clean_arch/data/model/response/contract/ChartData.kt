package com.brainvire.mvvm_clean_arch.data.model.response.contract

import com.google.gson.annotations.SerializedName

data class ChartData(
    @SerializedName("x_label")
    val xLabel: String? = null, // 2023-09-29
    @SerializedName("y_value")
    val yValue: Float? = null // 0
)
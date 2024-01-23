package com.brainvire.mvvm_clean_arch.data.model.request.food2fork

import com.google.gson.annotations.SerializedName

data class ReqFood2Fork(
    @SerializedName("page")
    var page: Int = 1, //page
    @SerializedName("query")
    var query: String = "", // query
)
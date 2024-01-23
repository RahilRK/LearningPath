package com.brainvire.mvvm_clean_arch.data.model.response.food2fork


import com.google.gson.annotations.SerializedName

data class RespFood2Fork(
    @SerializedName("count")
    val count: Int? = 0, // 1087
    @SerializedName("next")
    val next: String? = "", // https://food2fork.ca/api/recipe/search/?page=2&query=beef+carrot+potato+onion
    @SerializedName("previous")
    val previous: Any? = Any(), // null
    @SerializedName("results")
    val results: List<Result?>? = listOf()
) {
    data class Result(
        @SerializedName("pk")
        val pk: Int? = 0, // 2050
        @SerializedName("title")
        val title: String? = "", // Chicken, sweet potato &amp; coconut curry
        @SerializedName("publisher")
        val publisher: String? = "", // jessica
        @SerializedName("featured_image")
        val featuredImage: String? = "", // https://nyc3.digitaloceanspaces.com/food2fork/food2fork-static/featured_images/2050/featured_image.png
        @SerializedName("rating")
        val rating: Int? = 0, // 50
        @SerializedName("source_url")
        val sourceUrl: String? = "", // http://www.bbcgoodfood.com/recipes/1555/chicken-sweet-potato-and-coconut-curry
        @SerializedName("description")
        val description: String? = "", // N/A
        @SerializedName("cooking_instructions")
        val cookingInstructions: Any? = Any(), // null
        @SerializedName("ingredients")
        val ingredients: List<String?>? = listOf(),
        @SerializedName("date_added")
        val dateAdded: String? = "", // November 11 2020
        @SerializedName("date_updated")
        val dateUpdated: String? = "", // November 11 2020
        @SerializedName("long_date_added")
        val longDateAdded: Int? = 0, // 1606349252
        @SerializedName("long_date_updated")
        val longDateUpdated: Int? = 0 // 1606349252
    )
}
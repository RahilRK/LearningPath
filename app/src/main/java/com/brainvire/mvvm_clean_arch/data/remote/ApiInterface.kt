package com.brainvire.mvvm_clean_arch.data.remote

import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.presentation.URLFactory.EP_Login
import com.shahen.provider.core.models.responses.login.RespLogin
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("api/json/v1/1/categories.php")
    suspend fun getCategoryList(): Response<CategoryListRespDTO>

    /*@GET("api/json/v1/1/filter.php")
    suspend fun getMealList(
        @Query("c") strCategory: String,
    ): Response<MealList>

    @GET("api/json/v1/1/search.php")
    suspend fun getSearchMealList(
        @Query("s") keyWord: String,
    ): Response<SearchMealList>

    @GET("api/json/v1/1/list.php")
    suspend fun getAreaList(
        @Query("a") a: String = "list",
    ): Response<AreaList>

    @GET("api/json/v1/1/filter.php")
    suspend fun getAreaWiseMealList(
        @Query("a") area: String,
    ): Response<MealList>

    @GET("api/json/v1/1/list.php")
    suspend fun getIngredientList(
        @Query("i") ingredient: String = "list",
    ): Response<IngredientList>

    @GET("api/json/v1/1/filter.php")
    suspend fun getIngredientWiseMealList(
        @Query("i") i: String = "i",
    ): Response<MealList>

    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetail(
        @Query("i") id: String = "i",
    ): Response<MealDetail>*/

    @POST(EP_Login)
    suspend fun login(@Body model: ReqLogin): AppResponse<RespLogin>

}
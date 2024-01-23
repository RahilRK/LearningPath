package com.brainvire.mvvm_clean_arch.data.remote

import com.brainvire.mvvm_clean_arch.data.model.CategoryListRespDTO
import com.brainvire.mvvm_clean_arch.data.model.request.ReqDirectOrderDashboard
import com.brainvire.mvvm_clean_arch.data.model.request.ReqLogin
import com.brainvire.mvvm_clean_arch.data.model.request.ReqOrderHistoryList
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.MainDashboardResponse
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data
import com.brainvire.mvvm_clean_arch.data.model.response.food2fork.RespFood2Fork
import com.brainvire.mvvm_clean_arch.data.model.response.my_profile.RespMyProfile
import com.brainvire.mvvm_clean_arch.data.model.response.order_history.RespOrderHistoryList
import com.brainvire.mvvm_clean_arch.util.URLFactory.EP_DASHBOARD_DATA
import com.brainvire.mvvm_clean_arch.util.URLFactory.EP_DIRECT_ORDER_DASHBOARD
import com.brainvire.mvvm_clean_arch.util.URLFactory.EP_Login
import com.brainvire.mvvm_clean_arch.util.URLFactory.EP_ORDER_HISTORY_LIST
import com.brainvire.mvvm_clean_arch.util.URLFactory.EP_USER_PROFILE
import com.brainvire.mvvm_clean_arch.util.URLFactory.UNREAD_NOTIFICATION
import com.shahen.provider.core.models.responses.login.RespLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET(EP_USER_PROFILE)
    suspend fun myProfileData(): AppResponse<RespMyProfile>

    @GET(UNREAD_NOTIFICATION)
    suspend fun unreadNotificationCount(): AppResponse<Any>

    @POST(EP_DIRECT_ORDER_DASHBOARD)
    suspend fun directOrderDashboard(@Body model: ReqDirectOrderDashboard): AppResponse<List<Data>>

    @GET(EP_DASHBOARD_DATA)
    suspend fun getMainDashboardData(): AppResponse<MainDashboardResponse>

    @POST(EP_ORDER_HISTORY_LIST)
    suspend fun orderHistoryList(@Body model: ReqOrderHistoryList): AppResponse<RespOrderHistoryList>

    /*todo food2fork*/
    @GET("api/recipe/search/?")
    suspend fun getFoodList(
        @Query("page") page: Int = 1,
        @Query("query") query: String = ""
    ): Response<RespFood2Fork>
}
package com.brainvire.mvvm_clean_arch.util

object Constants {

    const val HOME_SCREEN = "HomeScreen"
    const val ADD_NOTE_SCREEN = "AddNoteScreen"
    const val UPDATE_NOTE_SCREEN = "UpdateNoteScreen"

//    const val BASE_URL = "https://www.themealdb.com/"
    const val BASE_URL = "https://shahennew.demo.brainvire.dev/api/"

    const val HOME_SCREEN_TAG = "HomeScreen"
    const val SEARCH_MEAL_SCREEN_TAG = "SearchMealScreen"
    const val COUNTRY_MEAL_SCREEN_TAG = "CountryMealScreen"
    const val INGREDIENTS_MEAL_SCREEN_TAG = "IngredientsMealScreen"
    const val MEAL_DETAIL_SCREEN_TAG = "MealDetailScreen"
    const val Navigation_TAG = "Navigation"

    //todo meal navigation related
    const val HOME_ROUTE = "home"
    const val SEARCH_MEAL_SCREEN_ROUTE = "search_meal"
    const val COUNTRY_MEAL_ROUTE = "country_meal"
    const val INGREDIENTS_MEAL_ROUTE = "ingredients_meal"
    const val MEAL_DETAIL_ROUTE = "meal_detail"

    const val HOME_LABEL = "Home"
    const val SEARCH_MEAL_LABEL = "Search"
    const val COUNTRY_MEAL_LABEL = "Area"
    const val INGREDIENTS_MEAL_LABEL = "Ingredients"
    const val MEAL_DETAIL_LABEL = "Recipe"

    var currentScreen = "home"

    const val SERVICE_PROVIDER = "service_provider"
    const val PLATFORM = "android"
    const val ORDER_TYPE_CONTRACT = "membership"
    const val ORDER_TYPE_DIRECT_ORDER = "order"
    const val ORDER_TYPE_PRICES = "prices"
    const val ORDER_TYPE_SPECIAL_ORDER = "special_order"
    const val PASSWORD_MAX_LENGTH = 30
    const val PASSWORD_MIN_LENGTH = 8

    //todo shahen variable
    const val PREF_NAME = "shaheen_provider"
    const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    const val SERVER_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
    const val SERVER_DATE_TIME_FORMAT_CHAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ"
    const val DATE_FORMAT_YEAR = "dd/MM/yy"
    const val DATE_FORMAT_YEAR_THREE = "yyy-mm-dd"
    const val LOCAL_DATE_FORMAT = "dd/MM/yy"
    const val LOCAL_DATE_FORMAT_TWO = "dd/MM/yyyy"
    const val SEND_DATE_FORMAT = "dd/MM/yyyy"
    const val SERVER_DATE_FORMAT_TWO = "yyyy-MM-dd"
    const val SERVER_DATE_NOTIFICATION_FORMAT = "HH:mm"
    const val USER_NOTIFICATION_FORMAT = "hh:mm a"
    const val ORDER_DATE_FORMAT = "d MMM yyyy"
    const val TIMEZONE_FORMAT = "ZZZZZ"

    //todo order type
    const val SECTION_DIRECT_ORDER = "order"
    const val SECTION_SPECIAL_ORDER = "special_order"
    const val SECTION_CONTRACT = "membership"
    const val SECTION_CONTRACT_DASHBOARD = "membership_history"
    const val SECTION_PRICES = "prices"
    const val SECTION_DRIVER = "driver"
    const val SECTION_ADDITIONAL_DRIVER = "additional_driver"
    const val SECTION_TRUCK = "truck"
    const val SECTION_ORDER_HISTORY = "all"

    //todo shahen navigation screen key
    const val LOGIN_ROUTE = "login"
    const val DASHBOARD_ROUTE = "dashboard"
    const val ORDER_HISTORY_ROUTE = "order_history"
    const val MORE_ROUTE = "more"
    const val ORDER_DASHBOARD_ROUTE = "order_dashboard"
    const val ORDER_LIST_ROUTE = "order_list"

    //todo shahen navigation screen label
    const val LOGIN = "Login"
    const val DASHBOARD = "Dashboard"
    const val ORDER_HISTORY = "Order History"
    const val MORE = "More"
    const val ORDER_DASHBOARD = "Order Dashboard"
    const val ORDER_LIST = "Order List"

    const val BottomNavigation = "BottomNavigation"
    var shahenCurrentScreen = "dashboard"
}
package com.brainvire.mvvm_clean_arch.data.local

import android.content.SharedPreferences
import com.brainvire.mvvm_clean_arch.data.local.PrefConstant.PREF_ACCESS_TOKEN
import com.brainvire.mvvm_clean_arch.data.local.PrefConstant.PREF_FCM_FETCH_MILLIS
import com.brainvire.mvvm_clean_arch.data.local.PrefConstant.PREF_ORDER_TYPE
import com.brainvire.mvvm_clean_arch.data.local.PrefConstant.PREF_PROVIDER_ID
import com.brainvire.mvvm_clean_arch.data.local.PrefConstant.PREF_USER_ID
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_TYPE_DIRECT_ORDER
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_TYPE_SPECIAL_ORDER
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_TYPE_CONTRACT
import com.brainvire.mvvm_clean_arch.util.Constants.ORDER_TYPE_PRICES
import com.brainvire.mvvm_clean_arch.util.OrderType
import java.util.Locale
import javax.inject.Inject

class PreferenceManager @Inject constructor(private val prefrence: SharedPreferences) {

    fun storeLanguage(lang: String): Boolean {
        return prefrence.edit().putString("lang", lang).commit()
    }

    fun getLanguage(): String {
        var local = Locale.getDefault().language
        return prefrence.getString("lang", local).toString()
    }

    fun setLogin(value: Boolean) {
        prefrence.edit().putBoolean("isLogin", value).apply()
    }

    fun isLogin(): Boolean {
        return prefrence.getBoolean("isLogin", false)
    }

    //-------------------------------------------------------------/
    fun setUserId(value: Int?) {
        value?.let { prefrence.edit().putInt(PREF_USER_ID, it).apply() }
    }

    fun getUserId(): Int {
        return prefrence.getInt(PREF_USER_ID, 0)
    }

    fun setProviderId(value: Int?) {
        value?.let { prefrence.edit().putInt(PREF_PROVIDER_ID, it).apply() }
    }

    fun getProviderId(): Int {
        return prefrence.getInt(PREF_PROVIDER_ID, 0)
    }

    fun setAccessToken(accessToken: String) {
        prefrence.edit().putString(PREF_ACCESS_TOKEN, accessToken).apply()
    }

    fun getAccessToken(): String {
        return prefrence.getString(PREF_ACCESS_TOKEN, "").toString()
    }

    fun setDeviceToken(deviceToken: String) {
        prefrence.edit().putString(PrefConstant.PREF_DEVICE_TOKEN, deviceToken).apply()
    }

    fun getDeviceToken(): String {
        return prefrence.getString(PrefConstant.PREF_DEVICE_TOKEN, "").toString()
    }

    fun setOrderType(value: String) {
        prefrence.edit().putString(PREF_ORDER_TYPE, value).apply()
    }

    fun getOrderType(): OrderType {
        return when (prefrence.getString(PREF_ORDER_TYPE, "").toString()) {
            ORDER_TYPE_DIRECT_ORDER -> OrderType.DIRECT_ORDER
            ORDER_TYPE_SPECIAL_ORDER -> OrderType.SPECIAL_ORDER
            ORDER_TYPE_CONTRACT -> OrderType.CONTRACT
            ORDER_TYPE_PRICES -> OrderType.PRICES
            else -> OrderType.DIRECT_ORDER
        }
    }

    /**
     * Method to set FCM method fetch time in millis
     *
     * @param millis - millis in Long
     */
    fun setLastFCMMethodFetchTimeInMillis(millis: Long) {
        prefrence.edit().putLong(PREF_FCM_FETCH_MILLIS, millis).apply()
    }

    /**
     * Method to get FCM method fetch time in millis
     *
     * @return millis - millis in Long
     */
    fun getLastFCMMethodFetchTimeInMillis(): Long {
        return prefrence.getLong(PREF_FCM_FETCH_MILLIS, 0L)
    }

    fun clearPreferences() {
        prefrence.edit().clear().apply()
    }
}
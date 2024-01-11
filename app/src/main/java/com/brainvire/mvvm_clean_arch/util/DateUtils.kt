package com.brainvire.mvvm_clean_arch.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {

    fun toConvertDateFormat(date: String): String {
        return try {
            val inputFormat = SimpleDateFormat(Constants.SERVER_DATE_FORMAT, Locale.getDefault())
            val outputFormat = SimpleDateFormat(Constants.ORDER_DATE_FORMAT, Locale.getDefault())

            val sendDate: Date = inputFormat.parse(date) ?: Date()
            outputFormat.format(sendDate)
        } catch (e: Exception) {
            date
        }
    }

    fun toConvertDateTimeFormat(date: String): String {
        return try {
            val inputFormat = SimpleDateFormat(Constants.SERVER_DATE_TIME_FORMAT, Locale.getDefault())
            val outputFormat = SimpleDateFormat(Constants.ORDER_DATE_FORMAT, Locale.getDefault())

            val sendDate: Date = inputFormat.parse(date) ?: Date()

            outputFormat.format(sendDate)
        } catch (e: Exception) {
            date
        }
    }

    /**
     * This method is to convert date-time format from UTC format to Local format.
     *
     * @param dateString - sting date
     * @param utcDateFormat - current format of date-time which you want to convert
     * @param localDateFormat - required format of date-time which you want to get
     */
    fun convertUtcToLocalTime(
        dateString: String,
        utcDateFormat: String = Constants.SERVER_DATE_TIME_FORMAT_CHAT,
        localDateFormat: String = Constants.ORDER_DATE_FORMAT
    ): String {
        var date = ""
        try {
            val utcFormat = SimpleDateFormat(utcDateFormat, Locale.getDefault())
            //utcFormat.timeZone = TimeZone.getTimeZone("UTC")
            val localFormat = SimpleDateFormat(localDateFormat, Locale.getDefault())
            //localFormat.timeZone = TimeZone.getDefault()
            val sendDate = utcFormat.parse(dateString)

            date = localFormat.format(sendDate!!)
        } catch (e: ParseException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return date
    }

    /**
     * This method is to get timeZone from current time.
     *
     * @param format - format string for timezone
     */
    fun getLocalTimeZone(
        format: String = Constants.TIMEZONE_FORMAT
    ): String {
        var timeZone = ""
        try {
            val dateFormat = SimpleDateFormat(format, Locale.getDefault())
            timeZone = dateFormat.format(System.currentTimeMillis())
        } catch (e: ParseException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return timeZone
    }

    /**
     * Method to convert millis to time
     *
     * @param millis - milliseconds to convert
     * @param requiredFormat - required date format
     * @return - requiredFormat dateString
     */
    fun convertMillisToDateTime(millis: Long, requiredFormat: String = Constants.USER_NOTIFICATION_FORMAT): String {
        var timeString = ""
        try {
            val dateFormat = SimpleDateFormat(requiredFormat, Locale.getDefault())
            val date = Date(millis)
            timeString = dateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return timeString
    }
}
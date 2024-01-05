package com.brainvire.mvvm_clean_arch.common

import android.content.Context
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brainvire.mvvm_clean_arch.util.Constants.PASSWORD_MAX_LENGTH
import com.brainvire.mvvm_clean_arch.util.Constants.PASSWORD_MIN_LENGTH
import java.util.regex.Pattern

fun String.isEmailValid(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPasswordValid(): Boolean {
    return if (this.length < PASSWORD_MIN_LENGTH) {
        false
    } else this.length <= PASSWORD_MAX_LENGTH
}

fun String.isValidPasswordFormat(): Boolean {
    val passwordREGEX = Pattern.compile(
        "^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{8,}" +               //at least 8 characters
            "$"
    )
    return passwordREGEX.matcher(this).matches()
}

fun String.isValidPasswordHaveSequence(): Boolean {
    val minLength = 3 // Minimum length of a sequence
    fun hasSequence(s: CharSequence): Boolean {
        for (i in 0 until length - minLength + 1) {
            val sequence = substring(i, i + minLength)
            if (s.contains(sequence)) {
                return true
            }
        }
        return false
    }

    val hasAlphanumericSequence =
        hasSequence("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890")
    val hasSpecialCharSequence = hasSequence(" !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~")

    return !(hasAlphanumericSequence || hasSpecialCharSequence)
}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

internal fun Boolean?.orFalse(): Boolean = this ?: false

/**
 * This function is to initialize recycler by given layout manager and adapter block.
 * Recyclerview adapter is set by executing the adapterInitializationBlock.
 * Layout manager is set by using the manager parameter. By default LinearLayoutManager will be set.
 *
 * This function is inline to optimize the usage of lambda argument in function.
 * Usage:
 * rvProjectList.apply {
 *   initialize(manager = LinearLayoutManager(context)) {
 *           projectListAdapter
 *       }
 *   }
 * @param manager -> RecyclerView.LayoutManager which is set to the given recycler view.
 * @param adapterInitializationBlock -> lambda function which will get executed to set the given recycler view adapter.
 */
inline fun RecyclerView.initialize(
    manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context),
    adapterInitializationBlock: () -> RecyclerView.Adapter<out RecyclerView.ViewHolder>,
) {
    layoutManager = manager
    adapter = adapterInitializationBlock()
}

inline fun RecyclerView.initializeGrid(
    manager: RecyclerView.LayoutManager = GridLayoutManager(this.context, 2),
    adapterInitializationBlock: () -> RecyclerView.Adapter<out RecyclerView.ViewHolder>,
) {
    layoutManager = manager
    adapter = adapterInitializationBlock()
}

fun String.hasArabicLetter(): Boolean {
    for (c in this.toCharArray()) {
        if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.ARABIC) {
            return true
        }
    }
    return false
}

fun Int?.toSafeInt(): Int {
    return try {
        this!!
    } catch (e: Exception) {
        0
    }
}

fun Double?.toSafeDouble(): Double {
    return try {
        this!!
    } catch (e: java.lang.Exception) {
        0.0
    }
}

fun Long?.toSafeLong(): Long {
    return try {
        this!!
    } catch (e: java.lang.Exception) {
        0L
    }
}
package com.example.cryptoapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPref(appContext: Context) {
    private val context = appContext
    private val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    // Getters
    /**
     * Get String value from SharedPreferences at 'key'. If key not found, return ""
     * @param key SharedPreferences key
     * @return String value at 'key' or "" (empty String) if key not found
     */
    fun getString(key: String?): String? {
        return preferences.getString(key, "")
    }


    // Put methods
    /**
     * Put String value into SharedPreferences with 'key' and save
     * @param key SharedPreferences key
     * @param value String value to be added
     */
    fun putString(key: String?, value: String?) {
        Utils().checkForNull(key)
        Utils().checkForNull(value)
        preferences.edit().putString(key, value).apply()
    }
}
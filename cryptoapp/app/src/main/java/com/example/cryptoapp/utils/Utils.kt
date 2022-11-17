package com.example.cryptoapp.utils

class Utils() {
    /**
     * null keys would corrupt the shared pref file and make them unreadable this is a preventive measure
     * @param key the pref key to check
     */
    fun checkForNull(string: String?) {
        if (string == null) {
            throw NullPointerException()
        }
    }
}
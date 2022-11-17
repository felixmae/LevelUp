package com.example.cryptoapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptoapp.utils.SharedPref

open class BaseActivity : AppCompatActivity() {
    protected val userData: SharedPref by lazy {
        SharedPref(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            hide()
            setDisplayShowTitleEnabled(false)
        }
    }
}
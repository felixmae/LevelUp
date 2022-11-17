package com.example.cryptoapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.cryptoapp.BuildConfig
import com.example.cryptoapp.R
import com.example.cryptoapp.ui.base.BaseActivity
import com.example.cryptoapp.ui.login.LoginActivity
import com.example.cryptoapp.ui.main.MainActivity
import com.example.cryptoapp.utils.Constant.DELAY_TO_START
import com.example.cryptoapp.utils.Constant.USER_NAME
import com.example.cryptoapp.utils.Constant.USER_NAME_KEY
import com.example.cryptoapp.utils.Constant.USER_PASSWORD
import com.example.cryptoapp.utils.Constant.USER_PASSWORD_KEY

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (userData.getString(USER_NAME_KEY).isNullOrEmpty())
            userData.putString(USER_NAME_KEY, USER_NAME)
        if (userData.getString(USER_PASSWORD_KEY).isNullOrEmpty())
            userData.putString(USER_PASSWORD_KEY, USER_PASSWORD)

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }, DELAY_TO_START)
    }

    companion object {
        val TAG = javaClass.simpleName
    }
}
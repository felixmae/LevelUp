package com.example.cryptoapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.example.cryptoapp.BuildConfig
import com.example.cryptoapp.R
import com.example.cryptoapp.ui.base.BaseActivity
import com.example.cryptoapp.ui.main.MainActivity
import com.example.cryptoapp.utils.Constant
import com.example.cryptoapp.utils.Constant.USER_NAME_KEY
import com.example.cryptoapp.utils.Constant.USER_PASSWORD_KEY

class LoginActivity : BaseActivity() {
    private lateinit var login : Button
    private lateinit var user : EditText
    private lateinit var pass : EditText
    private lateinit var textPass : TextView
    private lateinit var textUser : TextView
    private lateinit var animationLoading :LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login = findViewById<Button>(R.id.btnLogin)
        user = findViewById<EditText>(R.id.etUser)
        pass = findViewById<EditText>(R.id.etPassword)
        textPass = findViewById<TextView>(R.id.tvPasswordLabel)
        textUser = findViewById<TextView>(R.id.tvUserLabel)
        animationLoading = findViewById<LottieAnimationView>(R.id.animationView)

        login.setOnClickListener {
            hideKeyboard()
            if (user.text.isNullOrEmpty() || pass.text.isNullOrEmpty()) {
                Toast.makeText(
                    it.context, "User or password can not be empty", Toast.LENGTH_SHORT
                ).show()
            } else {
                val isValidUser = validateUser(
                    user.text.toString(),
                    pass.text.toString(),
                )
                user.visibility = View.GONE
                pass.visibility = View.GONE
                textPass.visibility = View.GONE
                textUser.visibility = View.GONE
                animationLoading.visibility = View.VISIBLE
                animationLoading.playAnimation()
                Handler().postDelayed({
                    animationLoading.visibility = View.GONE
                    if (BuildConfig.DEBUG) Log.i(TAG, "Starting app = $isValidUser")
                    if (isValidUser) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        user.visibility = View.VISIBLE
                        pass.visibility = View.VISIBLE
                        textPass.visibility = View.VISIBLE
                        textUser.visibility = View.VISIBLE
                        Toast.makeText(
                            it.context, "Error in user or password", Toast.LENGTH_SHORT
                        ).show()
                    }
                }, Constant.DELAY_TO_LOGIN)
                user.text.clear()
                pass.text.clear()
            }
        }
        if (BuildConfig.DEBUG) Log.i(TAG, "Login User")
    }

    override fun onStart() {
        super.onStart()
        user.visibility = View.VISIBLE
        pass.visibility = View.VISIBLE
        textPass.visibility = View.VISIBLE
        textUser.visibility = View.VISIBLE
        animationLoading.visibility = View.GONE
    }

    private fun hideKeyboard() {
        val inputManager = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun validateUser(user: String?, pass: String?): Boolean {
        val userApp = userData.getString(USER_NAME_KEY) ?: ""
        val passApp = userData.getString(USER_PASSWORD_KEY) ?: ""
        return userApp == user && passApp == pass
    }

    companion object {
        val TAG = javaClass.simpleName
    }
}
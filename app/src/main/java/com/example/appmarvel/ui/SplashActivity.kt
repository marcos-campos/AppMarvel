package com.example.appmarvel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.appmarvel.MainActivity
import com.example.appmarvel.R
import com.example.appmarvel.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed({

            startActivity(Intent(this , LoginActivity::class.java))

            finish ()
        },5000)

    }
}
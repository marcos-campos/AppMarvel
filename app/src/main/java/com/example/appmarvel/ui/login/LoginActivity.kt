package com.example.appmarvel.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmarvel.R
import com.example.appmarvel.ui.clickImage.ClickImageFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerLogin, LoginFragment.newInstance())
                .commitNow()
        }
    }
}
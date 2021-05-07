package com.example.appmarvel.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.appmarvel.R
import com.example.appmarvel.ui.clickImage.ClickImageFragment
import com.example.appmarvel.ui.clickImage.ClickImageFragment.Companion.newInstance
import com.example.appmarvel.ui.details.DetailsFragment.Companion.newInstance
import com.example.appmarvel.ui.main.MainFragment.Companion.newInstance

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.containerLogin, LoginFragment.newInstance())
//                .commitNow()
//
//        }
    }
}
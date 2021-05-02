package com.example.appmarvel.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmarvel.R
import com.example.appmarvel.model.Result
import com.example.appmarvel.ui.main.MainFragment

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val info = intent.extras
        val comicsInfo = info?.getSerializable("infoComics") as Result

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.containerDetails, DetailsFragment.newInstance(comicsInfo))
                    .commitNow()
        }
    }
}
package com.example.appmarvel.ui.clickImage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmarvel.R
import com.example.appmarvel.model.Result
import com.example.appmarvel.model.Thumbnail
import com.example.appmarvel.ui.details.DetailsFragment

class ClickImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.click_image_activity)

        val information = intent.extras
        val infoImage = information?.getSerializable("information") as Result

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerClick, ClickImageFragment.newInstance(infoImage))
                .commitNow()
        }
    }
}
package com.example.appmarvel.ui.clickImage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.appmarvel.R
import com.example.appmarvel.model.Result
import com.example.appmarvel.model.Thumbnail
import com.squareup.picasso.Picasso

class ClickImageFragment(private val comicsInfo: Result) : Fragment() {

    val imageComics by lazy { view?.findViewById<ImageView>(R.id.iv_click_image) }
    val buttonImageBack by lazy { view?.findViewById<Button>(R.id.button_image_back) }

    companion object {
        fun newInstance(comicsInfo: Result) = ClickImageFragment(comicsInfo)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.click_image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Picasso.with(activity).load(comicsInfo.thumbnail?.path + ".jpg").fit().into(imageComics)

        buttonImageBack?.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}
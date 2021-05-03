package com.example.appmarvel.ui.details

import android.content.Intent
import android.os.Build
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
import com.example.appmarvel.ui.clickImage.ClickImageActivity
import com.squareup.picasso.Picasso
import java.time.LocalDate


class DetailsFragment(private val comicsInfo: Result) : Fragment() {

    val imageComics by lazy { view?.findViewById<ImageView>(R.id.iv_detail_image) }
    val imageComics2 by lazy { view?.findViewById<ImageView>(R.id.iv_detail_image2) }
    val titleComics by lazy { view?.findViewById<TextView>(R.id.tv_detail_name) }
    val descriptionComics by lazy { view?.findViewById<TextView>(R.id.tv_detail_description) }
    val pricetionComics by lazy { view?.findViewById<TextView>(R.id.tv_detail_price_api) }
    val dateComics by lazy { view?.findViewById<TextView>(R.id.tv_detail_published_api) }
    val pagesComics by lazy { view?.findViewById<TextView>(R.id.tv_detail_page_api) }
    val buttonBack by lazy { view?.findViewById<Button>(R.id.button_back) }

    companion object {
        fun newInstance(comicsInfo: Result) = DetailsFragment(comicsInfo)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        titleComics?.text = comicsInfo.title
        descriptionComics?.text = comicsInfo.description.toString()
        pricetionComics?.text = comicsInfo.prices.toString()
        dateComics?.text = comicsInfo.dates.toString()
        pagesComics?.text = comicsInfo.pageCount.toString()
        Picasso.with(activity).load(comicsInfo.thumbnail?.path + ".jpg").into(imageComics)
        Picasso.with(activity).load(comicsInfo.thumbnail?.path + ".jpg").fit().into(imageComics2)

        imageComics2?.setOnClickListener {
            val intent2 = Intent(it.context, ClickImageActivity::class.java)
            intent2.putExtra("information", comicsInfo)
            activity?.startActivity(intent2)
        }

        buttonBack?.setOnClickListener {
            activity?.onBackPressed()
        }

    }

}





package com.example.appmarvel.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmarvel.R

class ViewHolderComics  (view: View): RecyclerView.ViewHolder(view) {

    val comicsTitle by lazy { view.findViewById<TextView>(R.id.recycler_comics_title)}
    val comicsImage by lazy { view.findViewById<ImageView>(R.id.recycler_comics_image)}

}
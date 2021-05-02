package com.example.appmarvel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmarvel.R
import com.example.appmarvel.model.Result
import com.squareup.picasso.Picasso

class AdapterComics(
        private val listComics: MutableList<Result>,
        private val context: Context
): RecyclerView.Adapter<ViewHolderComics>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderComics {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_list_comics, parent, false)
        return ViewHolderComics(view)
    }

    override fun getItemCount(): Int = listComics.size

    override fun onBindViewHolder(holder: ViewHolderComics, position: Int) {
        val titleComics = holder.comicsTitle
        titleComics.text = "# " + listComics[position].id.toString()

        val imageComics = holder.comicsImage
        Picasso.with(context).load(listComics[position].thumbnail?.path +".jpg").fit().into(imageComics)
    }
}
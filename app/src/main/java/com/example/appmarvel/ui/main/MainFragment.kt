package com.example.appmarvel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmarvel.R
import com.example.appmarvel.adapter.AdapterComics
import com.example.appmarvel.model.Result

class MainFragment : Fragment() {

    val recycler by lazy { view?.findViewById<RecyclerView>(R.id.recycler_list_comics) }
    private var comicsList = mutableListOf<Result>()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getComicsCoroutines()

        recycler?.layoutManager = GridLayoutManager(activity,3)

        viewModel.comicsLiveData.observe(this, Observer { result ->

            comicsList.addAll(result)

            val listComicWithImage = arrayListOf<Result>()

            comicsList.forEach {comics ->
                comics.thumbnail?.path?.let {
                    if (!it.contains("image_not_available")) {
                        listComicWithImage.add(comics)
                    }
                }
            }

            val adapter = activity.let { it?.let { it1 -> AdapterComics(listComicWithImage, it1) } }
            recycler?.adapter = adapter

            adapter?.notifyDataSetChanged()
        })
    }
}
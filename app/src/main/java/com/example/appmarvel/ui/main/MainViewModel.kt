package com.example.appmarvel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmarvel.model.Result
import com.example.appmarvel.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MainViewModel : ViewModel() {
    val comicsLiveData = MutableLiveData<ArrayList<Result>>()
    val repository = RepositoryApi()
    val errorMessage = MutableLiveData<String>()
    val loadingComics = MutableLiveData<Boolean>()

    fun getComicsCoroutines(){
        CoroutineScope(Dispatchers.IO).launch {
            loadingComics.postValue(true)
            try {
                repository.getComicsApi().let {
                    comicsLiveData.postValue(it.data?.results as ArrayList<Result>)
                    loadingComics.postValue(false)
                }
            }
            catch (error: Throwable){
                loadingComics.postValue(false)
                sendError(error)
            }
        }
    }

    private fun sendError(error: Throwable) {
        when(error){
            is UnknownHostException -> errorMessage.postValue("Check your connection")
        }
    }
}
package com.example.appmarvel.network

import com.example.appmarvel.model.ComicsResponse
import retrofit2.http.GET

interface EndPoints {

    @GET("comics?")
    suspend fun getComics(
    ): ComicsResponse
}
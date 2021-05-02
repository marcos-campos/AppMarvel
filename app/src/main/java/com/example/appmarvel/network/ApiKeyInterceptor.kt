package com.example.appmarvel.network

import com.example.appmarvel.repository.RepositoryApi
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest: Request = chain.request()
        val originalUrl: HttpUrl = originalRequest.url
        val newUrl: HttpUrl = originalUrl.newBuilder()
            .addQueryParameter("ts", RepositoryApi.keyTs)
            .addQueryParameter("hash", RepositoryApi.keyHash)
            .addQueryParameter("apikey", RepositoryApi.keyApi)
            .addQueryParameter("limit", "100")
            .build()
        val requestBuilder: Request.Builder = originalRequest.newBuilder()
            .url(newUrl)
        val request: Request = requestBuilder.build()

        return chain.proceed(request)

    }

}
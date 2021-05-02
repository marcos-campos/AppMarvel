package com.example.appmarvel.repository

import com.example.appmarvel.model.ComicsResponse
import com.example.appmarvel.network.EndPoints
import com.example.appmarvel.network.RetrofitInit
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class RepositoryApi {

    companion object{

        val publicKey : String? = "08545e608cd141bceb20dcf7c4a06b9a"
        val privateKey : String? = "9765b78fe32ea161d078455588f9585751fee3b4"
        val page : String? = "1"
        val orderBy : String? = "name"
        var ts: String? = "1"
        var hash: String? = md5(ts + privateKey + publicKey)

        var keyTs = "1"
        var keyHash = hash.toString()
        var keyApi = "08545e608cd141bceb20dcf7c4a06b9a"

        fun md5(s: String): String? {
            val MD5 = "MD5"
            try {
                // Create MD5 Hash
                val digest = MessageDigest
                    .getInstance(MD5)
                digest.update(s.toByteArray())
                val messageDigest = digest.digest()

                // Create Hex String
                val hexString = StringBuilder()
                for (aMessageDigest in messageDigest) {
                    var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                    while (h.length < 2) h = "0$h"
                    hexString.append(h)
                }
                return hexString.toString()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            return ""
        }

    }

    private var url = "http://gateway.marvel.com/v1/public/"

    private var service = EndPoints::class

    private val conectionService = RetrofitInit(url).create(service)

    suspend fun getComicsApi(): ComicsResponse = conectionService.getComics()

}
package com.example.appmarvel.model

import com.google.gson.annotations.SerializedName

data class Series(

        @SerializedName("name")
    val name: String?,

        @SerializedName("resourceURI")
    val resourceURI: String?
)
package com.example.appmarvel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Price(

        @SerializedName("price")
    val price: Float?,

        @SerializedName("type")
    val type: String?
)  : Serializable
package com.example.appmarvel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CollectedIssue(

        @SerializedName("name")
    val name: String?,

        @SerializedName("resourceURI")
    val resourceURI: String?
)  : Serializable
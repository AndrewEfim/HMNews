package com.example.data.entity

import com.google.gson.annotations.SerializedName

class NewsResponse(
        @SerializedName("objectId")
        val id: String,
        @SerializedName("title")
        val title:String,
        @SerializedName("articleimage")
        val imageurl:String,
        @SerializedName("article")
        val article:String
) {
}
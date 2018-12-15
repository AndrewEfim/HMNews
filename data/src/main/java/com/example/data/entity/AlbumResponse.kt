package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class AlbumResponse(
        @SerializedName("objectId")
        val id: String,
        @SerializedName("bandName")
        val bandName:String,
        @SerializedName("name")
        val name: String,
        @SerializedName("year")
        val year: String,
        @SerializedName("imageurl")
        val imageurl: String,
        @SerializedName("tracklist")
        val tracklist: String

) : DataEntity
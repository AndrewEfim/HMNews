package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class AlbumRequest(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("year")
        val year: String,
        @SerializedName("bandName")
        val bandName : String,
        @SerializedName("imageurl")
        val imageurl: String) : DataEntity

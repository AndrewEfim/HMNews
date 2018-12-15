package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class AlbumDeleteRequest(
        @SerializedName("id")
        val id: String
) : DataEntity
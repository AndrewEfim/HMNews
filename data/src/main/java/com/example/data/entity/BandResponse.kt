package com.example.data.entity

import com.google.gson.annotations.SerializedName

class BandResponse(
        @SerializedName("objectId")
        val id:String,
        @SerializedName("name")
        val name:String) {
}
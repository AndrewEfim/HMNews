package com.example.domain.entity

data class Album (val id:String,
                  val name:String,
                  val imageurl: String,
                  val year:String,
                  val bandName:String,
                  val tracklist:String):DomainEntity {


}
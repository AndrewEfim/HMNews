package com.example.domain.entity

fun AlbumsSearch.transformToSearchRequest():String{
    return "name LIKE '$name%'"
}

fun AlbumSearchByName.transformToSearchByNameRequest():String{
    return "bandName LIKE '$bandName%'"
}
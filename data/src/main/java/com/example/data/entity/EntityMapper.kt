package com.example.data.entity

import com.example.domain.entity.Album
import com.example.domain.entity.Band
import com.example.domain.entity.News

fun AlbumResponse.transformToDomain():Album{
    return Album(id=id,name=name,year=year,imageurl = imageurl,tracklist = tracklist, bandName = bandName)
}


fun Album.transformToRequest(): AlbumRequest {
    return AlbumRequest(id=id, name = name, year = year, imageurl = imageurl,bandName = bandName)
}

fun NewsResponse.transformToDomain(): News {
    return News(id=id,title=title,imageurl = imageurl,article=article)
}

fun BandResponse.transformToDomain():Band{
    return Band(id=id,name = name)
}
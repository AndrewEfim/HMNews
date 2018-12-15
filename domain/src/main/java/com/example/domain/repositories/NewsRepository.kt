package com.example.domain.repositories

import com.example.domain.entity.News
import io.reactivex.Observable

interface NewsRepository : BaseRepository {

    fun getNews():Observable<List<News>>
    fun getNewsById(id:String):Observable<News>

}
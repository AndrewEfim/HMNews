package com.example.data.repositories

import android.util.Log
import com.example.data.entity.transformToDomain
import com.example.data.net.RestService
import com.example.domain.entity.News
import com.example.domain.repositories.NewsRepository
import io.reactivex.Observable


class NewsRepositoryImpl(val apiService: RestService) : NewsRepository {

    val TAG: String = "myLog"

    override fun getNews(): Observable<List<News>> {
        Log.d(TAG, "getNews")
        return apiService.getNews().map { list -> list.map { it.transformToDomain() } }
    }

    override fun getNewsById(id: String): Observable<News> {
        Log.d(TAG, "getNewsById")
        return apiService.getNewsById(id).map { it -> it.transformToDomain() }
    }
}
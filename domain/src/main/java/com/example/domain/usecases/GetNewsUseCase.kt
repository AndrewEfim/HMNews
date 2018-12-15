package com.example.domain.usecases

import com.example.domain.entity.News
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.NewsRepository
import io.reactivex.Observable

class GetNewsUseCase(postExecutorThread: PostExecutorThread,
                     private val newsRepository: NewsRepository) : BaseUseCase(postExecutorThread) {

    fun get(): Observable<List<News>> {
        return newsRepository.getNews()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
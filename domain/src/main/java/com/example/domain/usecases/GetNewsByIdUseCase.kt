package com.example.domain.usecases

import com.example.domain.entity.News
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.NewsRepository
import io.reactivex.Observable

class GetNewsByIdUseCase(postExecutorThread: PostExecutorThread,
                         private val newsRepository: NewsRepository) : BaseUseCase(postExecutorThread) {

    fun getNewsById(id: String): Observable<News> {
        return newsRepository.getNewsById(id)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
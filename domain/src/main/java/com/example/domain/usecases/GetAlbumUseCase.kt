package com.example.domain.usecases

import com.example.domain.entity.Album
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.AlbumRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

class GetAlbumUseCase(postExecutorThread: PostExecutorThread,
                      private val albumRepository: AlbumRepository):BaseUseCase(postExecutorThread) {

    fun get(): Observable<List<Album>> {
        return albumRepository.getAlbum()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }


}

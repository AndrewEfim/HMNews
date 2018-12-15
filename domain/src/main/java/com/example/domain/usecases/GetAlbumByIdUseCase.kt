package com.example.domain.usecases

import com.example.domain.entity.Album
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.AlbumRepository
import io.reactivex.Observable

class GetAlbumByIdUseCase(postExecutorThread: PostExecutorThread,
                          private val albumRepository:AlbumRepository):BaseUseCase(postExecutorThread) {

    fun getAlbumById(id:String):Observable<Album>{
        return albumRepository.getAlbumById(id)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
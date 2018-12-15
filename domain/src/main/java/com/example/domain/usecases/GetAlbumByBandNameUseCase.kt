package com.example.domain.usecases

import com.example.domain.entity.Album
import com.example.domain.entity.AlbumSearchByName
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.AlbumRepository
import io.reactivex.Observable

class GetAlbumByBandNameUseCase(postExecutorThread: PostExecutorThread,
                                private val albumRepository: AlbumRepository):BaseUseCase(postExecutorThread) {

    fun getAlbumByBandName(bandName:String):Observable<List<Album>>{
        return albumRepository.getAlbumByBandName(bandName)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
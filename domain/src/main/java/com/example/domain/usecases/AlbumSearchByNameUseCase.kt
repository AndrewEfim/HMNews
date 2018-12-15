package com.example.domain.usecases

import com.example.domain.entity.Album
import com.example.domain.entity.AlbumSearchByName
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.AlbumRepository
import io.reactivex.Observable

class AlbumSearchByNameUseCase(postExecutorThread: PostExecutorThread,
                               val albumRepository: AlbumRepository) : BaseUseCase(postExecutorThread) {

    fun searchByBandName(searchByName: AlbumSearchByName): Observable<List<Album>> {
        return albumRepository.searchAlbumByBandName(searchByName)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }

}
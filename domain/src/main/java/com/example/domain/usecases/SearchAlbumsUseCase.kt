package com.example.domain.usecases

import com.example.domain.entity.Album
import com.example.domain.entity.AlbumsSearch
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.AlbumRepository
import io.reactivex.Observable

class SearchAlbumsUseCase (
        postExecutorThread: PostExecutorThread,
        private val albumRepository: AlbumRepository):BaseUseCase(postExecutorThread){

    fun search (searchAlbum:AlbumsSearch):Observable<List<Album>>{
        return albumRepository.searchAlbum(searchAlbum)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
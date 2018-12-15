package com.example.domain.repositories

import com.example.domain.entity.Album
import com.example.domain.entity.AlbumSearchByName
import com.example.domain.entity.AlbumsSearch
import io.reactivex.Observable

interface AlbumRepository : BaseRepository {

    fun getAlbum(): Observable<List<Album>>

    fun getAlbumById(id: String): Observable<Album>

    fun getAlbumByBandName(name: String): Observable<List<Album>>

    fun searchAlbum(search: AlbumsSearch): Observable<List<Album>>

    fun searchAlbumByBandName(search:AlbumSearchByName):Observable<List<Album>>





}
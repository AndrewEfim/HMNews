package com.example.data.repositories

import android.util.Log
import com.example.data.entity.transformToDomain
import com.example.data.net.RestService
import com.example.domain.entity.*
import com.example.domain.repositories.AlbumRepository
import io.reactivex.Observable

//,
class AlbumRepositotyImpl(val apiService: RestService) : AlbumRepository {

    val TAG: String = "myLogARdata"

    override fun getAlbum(): Observable<List<Album>> {
        Log.d(TAG, "getAlbum from Albumreposotory Impl")
        return apiService.getAlbums().map { list -> list.map { it -> it.transformToDomain() } }
    }

    override fun getAlbumByBandName(name: String): Observable<List<Album>> {
        return apiService.getAlbumsByBandName(name).map { list -> list.map { it.transformToDomain() } }

    }

    override fun searchAlbum(search: AlbumsSearch): Observable<List<Album>> {
        Log.d(TAG, "searchAlbum Album repositoryImpl")
        return apiService.searchAlbum(search.transformToSearchRequest())
                .map { list -> list.map { album -> album.transformToDomain() } }
    }

    override fun searchAlbumByBandName(search: AlbumSearchByName): Observable<List<Album>> {
        Log.d(TAG, "searchAlbumByBandName Album repositoryImpl")
        return apiService.searchAlbumByBandName(search.transformToSearchByNameRequest())
                .map { list -> list.map { album -> album.transformToDomain() } }
    }

    override fun getAlbumById(id: String): Observable<Album> {
        Log.d(TAG, "getAlbumById Album repositoryImpl" + apiService.getAlbumById(id).map { it.transformToDomain() })
        return apiService.getAlbumById(id).map { it.transformToDomain() }
    }
}



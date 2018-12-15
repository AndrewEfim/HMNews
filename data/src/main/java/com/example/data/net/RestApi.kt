package com.example.data.net

import com.example.data.entity.*
import com.example.domain.entity.Album
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface RestApi {

    @GET("albumslist")//albumlist
    fun getAlbums(): Observable<List<AlbumResponse>> // rest api

    @GET("news")
    fun getNews(): Observable<List<NewsResponse>>

    @GET("news/{id}")
    fun getNewsById(@Path("id") id: String): Observable<NewsResponse>

    @GET("bands")
    fun getBands():Observable<List<BandResponse>>

    @GET("albumslist/{id}")
    fun getAlbumsById(@Path("id") id: String): Observable<AlbumResponse>

    @GET("albumslist/{bandName}")
    fun getAlbumByBandName(@Path("bandName") bandName:String):Observable<List<AlbumResponse>>

    @GET("albumslist")
    fun searchAlbumByBandName(@Query("where") bandName:String):Observable<List<AlbumResponse>>

    @GET("albumslist")
    fun searchAlbum(@Query("where") name: String): Observable<List<AlbumResponse>>







}
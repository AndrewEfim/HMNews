package com.example.data.net

import android.content.ContentValues.TAG
import android.util.Log
import com.example.data.entity.AlbumResponse
import com.example.data.entity.BandResponse
import com.example.data.entity.NewsResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestService(private val apiUrl: String) {
    private val restApi: RestApi

    init {
        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)

        okHttpBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build()
        restApi = retrofit.create(RestApi::class.java)
    }

    fun getBands():Observable<List<BandResponse>>{
        return restApi.getBands()
    }

    fun getNews():Observable<List<NewsResponse>>{
        return restApi.getNews()
    }

    fun getNewsById(id:String):Observable<NewsResponse>{
        return restApi.getNewsById(id)
    }


    fun getAlbums(): Observable<List<AlbumResponse>> {
        return restApi.getAlbums()
    }

    fun getAlbumsByBandName(name:String):Observable<List<AlbumResponse>>{
        Log.d(TAG,"getAlbumsByBandNamne")
        return restApi.getAlbumByBandName(name)
    }

    fun getAlbumById(id: String): Observable<AlbumResponse> {
        return restApi.getAlbumsById(id)
        //Log.d(TAG,"getAlbumById(id:String):Observable<AlbumResponse>")
    }





    fun searchAlbum(name:String):Observable<List<AlbumResponse>>{
        return restApi.searchAlbum(name)
    }

    fun searchAlbumByBandName(bandName:String):Observable<List<AlbumResponse>>{
        return restApi.searchAlbumByBandName(bandName)
    }
}


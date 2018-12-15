package com.example.andreii.mysuperarchitecturealbum.presentation.screen.album.detail

import android.databinding.ObservableField
import android.util.Log
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseViewModel
import com.example.andreii.mysuperarchitecturealbum.presentation.fucturies.UseCaseProvider
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter
import io.reactivex.rxkotlin.subscribeBy


class AlbumDetailsViewModel : BaseViewModel<AlbumRouter>() {
    private val TAG: String = "myLog"
    private val albumIdUseCase = UseCaseProvider.providerAlbumIdUseCase()
    private var albumId: String? = null

    val albumName = ObservableField<String>("No Data")
    val albumImageUrl = ObservableField<String>("http://www.metallibrary.ru/bands/discographies/images/queen/pictures/73_queen.jpg")
    val albumID = ObservableField<String>("No Data")
    val albumYear = ObservableField<String>("No Data")
    val tracklist = ObservableField<String>("")


    fun setAlbumId(id: String) {
        if (albumId != null) return
        albumId = id
        Log.d(TAG, "AlbumDetailViewModel id = " + id)

        addToDisposable(albumIdUseCase.getAlbumById(id)
                .subscribeBy(
                        onNext = {
                            albumName.set(it.name)
                            albumYear.set(it.year)
                            albumImageUrl.set(it.imageurl)
                            tracklist.set(it.tracklist)

                            Log.d(TAG, "album name insid init=" + albumName.get())
                            Log.d(TAG, "album year insid init=" + albumYear.get())
                            Log.d(TAG, "album imageUrl insid init=" + albumImageUrl.get())

                        }, onError = {
                    Log.d(TAG, "it setAlbumId form detail fragment" + it.toString())
                    router?.showError(e = Throwable())
                }
                        , onComplete = {}))
        Log.d(TAG, "albumname: после init=" + albumName.get())
    }

    init {
    }
}




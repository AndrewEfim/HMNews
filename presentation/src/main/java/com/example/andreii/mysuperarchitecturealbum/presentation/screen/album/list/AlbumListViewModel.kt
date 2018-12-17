package com.example.andreii.mysuperarchitecturealbum.presentation.screen.album.list

import android.util.Log
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseViewModel
import com.example.andreii.mysuperarchitecturealbum.presentation.fucturies.UseCaseProvider
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.ApplicationMainRouter
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.album.MyAlbumAdapter
import com.example.domain.entity.AlbumSearchByName
import com.example.domain.entity.AlbumsSearch
import io.reactivex.rxkotlin.subscribeBy


class AlbumListViewModel : BaseViewModel<ApplicationMainRouter>() {
    val TAG: String = "myLogALVM"
    private val searchAlbumsUseCase = UseCaseProvider.provideAlbumSearchUseCase()
    private val albumSearchByNmaeUseCase = UseCaseProvider.provideAlbumSerchByNameUseCase()

    var myAdapter: MyAlbumAdapter = MyAlbumAdapter()

    private var nameA: String? = null


    init {


        myAdapter.setOnItemClickListner {
            router?.goToAlbumDetails(it.id)
            Log.d(TAG, "setOnItemClickListner переход на Detaill_List= " + it.id)
        }


    }

    fun getAlbumByBandName(name: String) {
        if (nameA != null) return
        nameA = name

        Log.d(TAG, "name from getAlbumByBandName " + name)
        val bandName = AlbumSearchByName(name)
        addToDisposable(albumSearchByNmaeUseCase.searchByBandName(bandName)
                .subscribeBy(onNext = {
                    myAdapter.setmAlbums(it)
                    myAdapter.notifyDataSetChanged()
                    Log.d(TAG, "getAlbumByBandName" + myAdapter.mAlbums.size)
                    Log.d(TAG, "getAlbumByBandName" + it.get(0).bandName)
                }, onError = {
                    router?.showError(it)
                    Log.d(TAG, "router?.showError(it)" + it.toString())
                }))

    }

    fun search(searchName: String) {

        val name = AlbumsSearch(searchName)
        addToDisposable(searchAlbumsUseCase.search(name).subscribeBy(
                onNext = {
                    myAdapter.setmAlbums(it)
                    myAdapter.notifyDataSetChanged()
                    Log.d(TAG, "View Model search" + it.toString())
                }, onError = {
            router?.showError(it)
            Log.d(TAG, "show Error" + it.toString())
        }

        ))
    }
}

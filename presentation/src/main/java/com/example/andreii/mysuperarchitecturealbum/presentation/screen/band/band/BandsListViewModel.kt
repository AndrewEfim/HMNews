package com.example.andreii.mysuperarchitecturealbum.presentation.screen.band.band

import android.util.Log
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseViewModel
import com.example.andreii.mysuperarchitecturealbum.presentation.fucturies.UseCaseProvider
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter
import io.reactivex.rxkotlin.subscribeBy

class BandsListViewModel : BaseViewModel<AlbumRouter>() {
    private val TAG : String = "myLog"
    private val bandsListUseCase = UseCaseProvider.provideBandsListUseCase()
    var myBandsAdapter: MyBandAdapter = MyBandAdapter()

    init {
        myBandsAdapter.setOnItemClickListner {
            router?.goToAlbumListByName(it.name)//
            Log.d(TAG, "goToAlbumListByName" + it.name)
        }
        addToDisposable(bandsListUseCase.get()
                .subscribeBy(onNext = {
                    myBandsAdapter.setmBands(it)

                }))

    }
}
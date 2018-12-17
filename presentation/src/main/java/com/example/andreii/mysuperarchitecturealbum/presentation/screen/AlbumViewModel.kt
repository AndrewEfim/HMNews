package com.example.andreii.mysuperarchitecturealbum.presentation.screen

import android.util.Log
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseViewModel

class AlbumViewModel : BaseViewModel<ApplicationMainRouter>() {
    private val TAG : String = "myLog"

    fun goToNewsList() {
        router?.goToNewsList()
        Log.d(TAG, "go To News List Method")
    }



    fun goToBandList() {
        router?.goToBandsList()
        Log.d(TAG, "goToBand List Method")

    }
}
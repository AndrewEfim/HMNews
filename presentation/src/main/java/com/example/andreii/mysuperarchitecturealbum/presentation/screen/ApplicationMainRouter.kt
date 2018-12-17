package com.example.andreii.mysuperarchitecturealbum.presentation.screen

import android.util.Log
import android.view.View
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseRouter
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.album.detail.AlbumDetailsFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.album.list.AlbumListFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.band.band.BandsListFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news.details.NewsDetailsFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news.list.NewsListFragment

class ApplicationMainRouter(activity: ApplicationMainActivity) : BaseRouter<ApplicationMainActivity>(activity) {

    fun goToBandsList() {
        replaceFragment(activity.supportFragmentManager
                , BandsListFragment.getInstance()
                , R.id.fragmentContainer, false)

    }

    fun goToAlbumListByName(name: String) {
        replaceFragment(activity.supportFragmentManager
                , AlbumListFragment.getInstance(name)
                , R.id.fragmentContainer, false)
    }

    fun goToNewsList() {
        replaceFragment(activity.supportFragmentManager
                , NewsListFragment.getInstance()
                , R.id.fragmentContainer, false)
        Log.d(TAG, "goToNewsList")
    }

    fun goToNewsDetails(id: String = "") {
        val conteinerDetails = activity.findViewById<View>(R.id.fragmentDetailsContainer)
        if (conteinerDetails == null) {
            replaceFragment(
                    activity.supportFragmentManager
                    , NewsDetailsFragment.getInstance(id)
                    , R.id.fragmentContainer, true)
        } else {
            replaceFragment(
                    activity.supportFragmentManager
                    , NewsDetailsFragment.getInstance(id)
                    , R.id.fragmentDetailsContainer, false)
        }
    }

    fun goToAlbumDetails(id: String = "") {
        val conteinerDetails = activity.findViewById<View>(R.id.fragmentDetailsContainer)
        if (conteinerDetails == null) {
            replaceFragment(
                    activity.supportFragmentManager
                    , AlbumDetailsFragment.getInstance(id)
                    , R.id.fragmentContainer, true)
        } else {
            replaceFragment(
                    activity.supportFragmentManager
                    , AlbumDetailsFragment.getInstance(id)
                    , R.id.fragmentDetailsContainer, false)
        }
    }
}
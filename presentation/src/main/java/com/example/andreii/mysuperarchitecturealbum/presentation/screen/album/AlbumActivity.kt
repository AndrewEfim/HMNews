package com.example.andreii.mysuperarchitecturealbum.presentation.screen.album

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.andreii.mysuperarchitecturealbum.databinding.ActivityMainAlbumBinding

import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseMvvmActivity
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumViewModel

class AlbumActivity : BaseMvvmActivity<
        AlbumViewModel
        , AlbumRouter
        , ActivityMainAlbumBinding>() {


    override fun provideViewModel(): AlbumViewModel {
        return ViewModelProviders.of(this).get(AlbumViewModel::class.java)

    }

    override fun provideRouter(): AlbumRouter {
        return AlbumRouter(this)
    }

    override fun provideLayourId(): Int = R.layout.activity_main_hmnews//R.layout.activity_main_album

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        val buttonNews: Button = findViewById(R.id.button_News_hmnews)
        val buttonBands: Button = findViewById(R.id.button_Bands_hmnews)

        if (savedInstanceState == null) {
            router.goToNewsList()

            buttonNews.setOnClickListener(View.OnClickListener {
                viewModel.goToNewsList()

            })
            buttonBands.setOnClickListener(View.OnClickListener {
                viewModel.goToBandList()
            })
        }
    }
}
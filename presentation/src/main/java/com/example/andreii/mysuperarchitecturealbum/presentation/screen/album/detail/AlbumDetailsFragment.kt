package com.example.andreii.mysuperarchitecturealbum.presentation.screen.album.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.andreii.mysuperarchitecturealbum.databinding.FragmentDetailAlbumBinding
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseMvvmFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter

class AlbumDetailsFragment : BaseMvvmFragment<AlbumDetailsViewModel
        , AlbumRouter, FragmentDetailAlbumBinding>() {

    private val TAG: String = "myLog"

    companion object {
        private const val ID_EXTRA = "ID_EXTRA"
        fun getInstance(id: String): AlbumDetailsFragment {
            val fragment = AlbumDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel(): AlbumDetailsViewModel {
        return ViewModelProviders.of(this).get(AlbumDetailsViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_detail_album
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(ID_EXTRA) as String
        Log.d(TAG, "ID_EXTRA" + id)
        Log.d(TAG, "id" + id)
        if (id != "") {
            viewModel.setAlbumId(id)
            Log.d(TAG, "Подали id на  выполнение viewModel.setAlbumId(id)" + id)
            Log.d(TAG, "Передали id после выполнения viewModel.setAlbumId(id)" + id)
        } else {
            router?.goBack()
        }

    }
}

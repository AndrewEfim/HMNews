package com.example.andreii.mysuperarchitecturealbum.presentation.screen.band.band

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.andreii.mysuperarchitecturealbum.databinding.FragmentBandsListBinding
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseMvvmFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter

class BandsListFragment : BaseMvvmFragment<BandsListViewModel, AlbumRouter, FragmentBandsListBinding>() {
    private val TAG : String = "myLog"
    companion object {
        fun getInstance(): BandsListFragment {
            return BandsListFragment()
        }
    }


    override fun provideViewModel(): BandsListViewModel {
        return ViewModelProviders.of(this).get(BandsListViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_bands_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewFragmentBandsList.adapter = viewModel.myBandsAdapter
        Log.d(TAG, "onViewCreated step 2 setadapter on binding =" + viewModel.myBandsAdapter.itemCount.toString())
        binding.recyclerViewFragmentBandsList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFragmentBandsList.setHasFixedSize(true)


    }
}
package com.example.andreii.mysuperarchitecturealbum.presentation.screen.album.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.andreii.mysuperarchitecturealbum.R

import com.example.andreii.mysuperarchitecturealbum.databinding.FragmentListAlbumBinding
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseMvvmFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_list_album.view.*

class AlbumListFragment : BaseMvvmFragment<
        AlbumListViewModel
        , AlbumRouter
        , FragmentListAlbumBinding>() {

    val TAG: String = "myLog"

    companion object {
        private const val NAME_EXTRA = "NAME_EXTRA"
        fun getInstance(name: String): AlbumListFragment {
            val fragment = AlbumListFragment()
            val bundle = Bundle()
            bundle.putString(NAME_EXTRA, name)
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun provideViewModel(): AlbumListViewModel {
        return ViewModelProviders.of(this).get(AlbumListViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_list_album

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var search: EditText = view.searchAllbum
        val name = arguments?.getString(AlbumListFragment.NAME_EXTRA) as String

        binding.recyclerViewAlbumList.adapter = viewModel.myAdapter
        Log.d(TAG, "onViewCreated step 2 setadapter on binding =" + viewModel.myAdapter.itemCount.toString())
        binding.recyclerViewAlbumList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewAlbumList.setHasFixedSize(true)

        if (name != "") {
            Log.d(TAG, "name " + name)
            viewModel.getAlbumByBandName(name)
        } else {
            router?.goBack()
        }


        RxTextView.textChanges(binding.searchAllbum)
                .subscribeBy {
                    viewModel.search(it.toString())
                    Log.d(TAG, "viewModel.search(it.toString())" + it.toString())
                }


        //.textChanges(binding.searchAllbum).subscribeBy {
        //viewModel.searching(it.toString())
    }

}

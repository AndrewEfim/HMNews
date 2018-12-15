package com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.andreii.mysuperarchitecturealbum.databinding.FragmentListNewsBinding
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseMvvmFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter

class NewsListFragment : BaseMvvmFragment<NewsListViewModel, AlbumRouter, FragmentListNewsBinding>() {


    companion object {
        fun getInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }


    override fun provideViewModel(): NewsListViewModel {
        return ViewModelProviders.of(this).get(NewsListViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_list_news
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerViewListNews.adapter = viewModel.myNewsAdapter

        binding.recyclerViewListNews.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewListNews.setHasFixedSize(true)


    }
}
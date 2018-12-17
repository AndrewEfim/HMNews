package com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.andreii.mysuperarchitecturealbum.R
import com.example.andreii.mysuperarchitecturealbum.databinding.FragmentDetailNewsBinding
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseMvvmFragment
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.ApplicationMainRouter

class NewsDetailsFragment : BaseMvvmFragment<NewsDetailsViewModel, ApplicationMainRouter, FragmentDetailNewsBinding>() {
    private val TAG : String = "myLog"

    companion object {
        private const val ID_EXTRA = "ID_EXTRA"
        fun getInstance(id: String): NewsDetailsFragment {
            val fragment = NewsDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel(): NewsDetailsViewModel {
        return ViewModelProviders.of(this).get(NewsDetailsViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_detail_news

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(NewsDetailsFragment.ID_EXTRA) as String

        if (id != "") {
            viewModel.setNewsById(id)
            Log.d(TAG, "newsByID " + id)
        } else {
            router?.goBack()
        }


    }


}
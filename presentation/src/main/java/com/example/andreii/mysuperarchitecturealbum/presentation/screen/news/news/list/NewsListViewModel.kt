package com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news.list

import android.util.Log
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseViewModel
import com.example.andreii.mysuperarchitecturealbum.presentation.fucturies.UseCaseProvider
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news.MyNewsAdapter
import io.reactivex.rxkotlin.subscribeBy

class NewsListViewModel : BaseViewModel<AlbumRouter>() {
    private val TAG : String = "myLog"

    private val newsListUseCase = UseCaseProvider.provideNewsListUseCase()
    var myNewsAdapter: MyNewsAdapter = MyNewsAdapter()


    init {
        myNewsAdapter.setOnItemClickListner {
            router?.goToNewsDetails(it.id)
        }

        addToDisposable(newsListUseCase.get()
                .subscribeBy(
                        onNext = {
                            myNewsAdapter.setmNews(it)
                            Log.d(TAG, "размер списка из адаптера после прихода данных news" + myNewsAdapter.mNews.size)
                        }, onError = {
                    router?.showError(it)

                }
                ))
    }

}



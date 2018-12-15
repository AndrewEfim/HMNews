package com.example.andreii.mysuperarchitecturealbum.presentation.screen.news.news.details

import android.databinding.ObservableField
import android.util.Log
import com.example.andreii.mysuperarchitecturealbum.presentation.base.BaseViewModel
import com.example.andreii.mysuperarchitecturealbum.presentation.fucturies.UseCaseProvider
import com.example.andreii.mysuperarchitecturealbum.presentation.screen.AlbumRouter
import io.reactivex.rxkotlin.subscribeBy

class NewsDetailsViewModel : BaseViewModel<AlbumRouter>() {

    private val TAG : String = "myLog"

    private val getNewsByIdUseCase = UseCaseProvider.provideNewsByIdUseCase()
    private var newsId: String? = null

    val title = ObservableField<String>("")
    val imageUrl = ObservableField<String>("http://www.metallibrary.ru/bands/discographies/images/queen/pictures/73_queen.jpg")
    val article = ObservableField<String>("")



    fun setNewsById(id: String) {
        if (newsId != null) return
        newsId = id
        addToDisposable(getNewsByIdUseCase.getNewsById(id)
                .subscribeBy(onNext = {
                    title.set(it.title)
                    article.set(it.article)
                    imageUrl.set(it.imageurl)
                    Log.d(TAG,"title" +title.toString())
                },onError = {
                    router?.showError(it)
                    Log.d(TAG,"router?.showError(it)"+it.toString())

                }))

    }
}
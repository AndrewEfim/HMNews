package com.example.domain.usecases

import com.example.domain.entity.Band
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.BandsRepository
import io.reactivex.Observable

class GetBandsUseCase(postExecutorThread: PostExecutorThread,
                      private val bandsRepository: BandsRepository):BaseUseCase(postExecutorThread) {

    fun get():Observable<List<Band>>{
        return bandsRepository.getBands()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
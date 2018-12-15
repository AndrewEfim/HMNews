package com.example.domain.usecases

import com.example.domain.entity.Album
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.AlbumRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAlbumUseCaseTest {
    @Mock
    lateinit var repository:AlbumRepository

    lateinit var postExecutorThread: PostExecutorThread

    init{


        `when`(repository.getAlbum()).thenReturn(
                Observable.just(arrayListOf(
                        Album("0","Album0","Image0","Year0)"),
                        Album("1","Album1","Image1","Year1)"),
                        Album("2","Album2","Image2","Year2)"),
                        Album("3","Album3","Image3","Year3)"),
                        Album("4","Album4","Image4","Year4)")

                ))
        )

    }
    @Test
    fun testSuc(){
        val testScheduler=TestScheduler()
        val useCase=GetAlbumUseCase(postExecutorThread,repository)
        useCase.get().test().assertNoValues()
    testScheduler.triggerActions()
    }

}
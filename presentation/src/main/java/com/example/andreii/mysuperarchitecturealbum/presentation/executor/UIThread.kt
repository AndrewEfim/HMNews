package com.example.andreii.mysuperarchitecturealbum.presentation.executor

import com.example.domain.executor.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutorThread {

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
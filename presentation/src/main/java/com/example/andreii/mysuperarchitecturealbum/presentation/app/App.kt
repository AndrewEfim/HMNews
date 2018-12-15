package com.example.andreii.mysuperarchitecturealbum.presentation.app

import android.app.Application

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }

}
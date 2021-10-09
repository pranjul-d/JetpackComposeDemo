package com.softradix.jetpackcomposedemo.application

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PostApplication : Application(){

    init {
        instance = this
    }

    companion object {
        private var instance: PostApplication? = null

        fun getContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        val context: Context = getContext()
    }
}
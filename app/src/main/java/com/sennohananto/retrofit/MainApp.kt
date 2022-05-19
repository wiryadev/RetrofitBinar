package com.sennohananto.retrofit

import android.app.Application
import com.sennohananto.retrofit.di.CoreComponent
import com.sennohananto.retrofit.di.DaggerAppComponent
import com.sennohananto.retrofit.di.DaggerCoreComponent

class MainApp : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }

}
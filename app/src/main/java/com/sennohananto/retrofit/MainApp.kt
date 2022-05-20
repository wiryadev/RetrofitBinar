package com.sennohananto.retrofit

import android.app.Application
import com.sennohananto.retrofit.di.databaseModule
import com.sennohananto.retrofit.di.networkModule
import com.sennohananto.retrofit.di.repositoryModule
import com.sennohananto.retrofit.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(
                listOf(
                    networkModule,
                    databaseModule,
                    repositoryModule,
                    viewModelModule,
                )
            )
        }
    }
}
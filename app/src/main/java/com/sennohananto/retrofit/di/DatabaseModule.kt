package com.sennohananto.retrofit.di

import androidx.room.Room
import com.sennohananto.retrofit.data.room.DbHelper
import com.sennohananto.retrofit.data.room.PostDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext().applicationContext,
            PostDatabase::class.java,
            "post_database"
        ).build()
    }
    single {
        get<PostDatabase>().postDao()
    }
    singleOf(::DbHelper)
}
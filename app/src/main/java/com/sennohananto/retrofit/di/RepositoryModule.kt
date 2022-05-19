package com.sennohananto.retrofit.di

import com.sennohananto.retrofit.data.Repository
import com.sennohananto.retrofit.data.service.ApiHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class
    ]
)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(apiHelper: ApiHelper): Repository {
        return Repository(apiHelper)
    }

}
package com.sennohananto.retrofit.di

import com.sennohananto.retrofit.data.Repository
import com.sennohananto.retrofit.data.service.ApiHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideRepository(apiHelper: ApiHelper) = Repository(apiHelper)

}
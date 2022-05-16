package com.sennohananto.retrofit.di

import com.sennohananto.retrofit.data.Repository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::Repository)
}
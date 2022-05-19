package com.sennohananto.retrofit.di

import com.sennohananto.retrofit.ui.MainActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [
        CoreComponent::class
    ],
    modules = [
        ViewModelModule::class,
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(mainActivity: MainActivity)

}
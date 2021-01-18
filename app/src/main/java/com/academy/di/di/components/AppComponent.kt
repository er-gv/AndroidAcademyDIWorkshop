package com.academy.di.di.components

import com.academy.db.di.DbModule
import com.academy.di.di.modules.DataStoreModule
import com.academy.di.di.modules.MoviesModule
import com.academy.di.ui.details.DetailsFragment
import com.academy.di.ui.home.HomeFragment
import com.academy.network.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

// TODO Step 2 - Add module ExamplesModule
@Component(modules = [DbModule::class, NetworkModule::class, MoviesModule::class,  DataStoreModule::class])
@Singleton
interface AppComponent {
    fun addSettingsSubComponent(): SettingsComponent.Builder

    fun inject(homeFragment: HomeFragment)
    fun inject(detailsFragment: DetailsFragment)
}
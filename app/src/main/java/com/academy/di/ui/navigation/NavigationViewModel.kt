package com.academy.di.ui.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.FragmentNavigator
import com.academy.db.model.Movie
import com.academy.di.ui.home.HomeFragmentDirections
import com.academy.di.utils.SingleLiveEvent

class NavigationViewModel : ViewModel() {
    private var navEvent = SingleLiveEvent<NavParams>()
    fun getNavEvent(): LiveData<NavParams> = navEvent

    // HomeFragment Actions
    fun onUserMovieClick(movie: Movie, extras: FragmentNavigator.Extras) {
        navEvent.value =
            NavParams(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movie), extras)
    }

    fun onSettingsClick() {
        navEvent.value = NavParams(HomeFragmentDirections.actionHomeFragmentToSettingsFragment())
    }
}
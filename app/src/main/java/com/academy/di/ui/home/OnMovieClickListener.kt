package com.academy.di.ui.home

import androidx.navigation.fragment.FragmentNavigator
import com.academy.db.model.Movie

interface OnMovieClickListener {
    fun onClick(movie: Movie, extras: FragmentNavigator.Extras, position: Int)
}
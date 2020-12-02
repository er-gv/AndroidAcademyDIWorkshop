package com.academy.di.repo

import com.academy.db.model.Movie
import com.academy.db.model.MovieModelConverter
import com.academy.di.di.Dependencies
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

class MoviesRepo : CoroutineScope {
    override val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.IO

    fun getMovies(): Flow<List<Movie>> {
        getFreshMoviesAndSaveThemToDBAsync()

        // Returns Flow with list of movies from database
        return Dependencies.getMovieDao().getMovies()
    }

    private fun getFreshMoviesAndSaveThemToDBAsync() {
        launch {
            // Fetch fresh list from TMDB API
            val movies = Dependencies.getApiServices().getMovies()
            // Convert from network to database model
            val convertedList: List<Movie> = MovieModelConverter.convert(movies)
            // Save converted list to the database
            Dependencies.getMovieDao().insertAll(convertedList)
        }
    }

    fun onCleared() {
        coroutineContext.cancelChildren()
    }
}
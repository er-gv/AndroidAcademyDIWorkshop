package com.academy.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.academy.db.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
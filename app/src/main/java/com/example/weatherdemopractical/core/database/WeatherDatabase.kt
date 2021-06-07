package com.example.weatherdemopractical.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherdemopractical.core.database.dao.BookmarkDao
import com.example.weatherdemopractical.core.database.entities.Bookmark

@Database(entities = [Bookmark::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val bookmarkDao: BookmarkDao

}

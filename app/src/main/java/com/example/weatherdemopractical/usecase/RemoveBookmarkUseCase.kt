package com.example.weatherdemopractical.usecase

import com.example.weatherdemopractical.core.database.dao.BookmarkDao
import com.example.weatherdemopractical.core.database.entities.Bookmark
import com.example.weatherdemopractical.model.domain.LocationWeatherModel

class RemoveBookmarkUseCase(private val dao: BookmarkDao) {

    suspend fun execute(locationWeather: LocationWeatherModel) = dao.delete(
        Bookmark(
            id = locationWeather.id,
            latitude = locationWeather.lat,
            longitude = locationWeather.lon
        )
    )
}

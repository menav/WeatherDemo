package com.example.weatherdemopractical.usecase

import com.example.weatherdemopractical.model.domain.LocationWeatherModel

class AddBookmarkUseCase(private val dao: com.example.weatherdemopractical.core.database.dao.BookmarkDao) {

    suspend fun execute(locationWeather: LocationWeatherModel) = dao.insert(
        com.example.weatherdemopractical.core.database.entities.Bookmark(
            id = locationWeather.id,
            latitude = locationWeather.lat,
            longitude = locationWeather.lon
        )
    )
}

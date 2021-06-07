package com.example.weatherdemopractical.usecase

import com.example.weatherdemopractical.model.dto.CityNetworkDto
import com.example.weatherdemopractical.service.network.WeatherApiService
import com.google.gson.Gson

class GetWeatherUseCase(private val weatherApiService: WeatherApiService) {

    suspend fun execute(lat: Double, lon: Double): CityNetworkDto {
        val response = weatherApiService.byGeoCoordinates(lat, lon)
        return Gson().fromJson(response, CityNetworkDto::class.java)
    }
}

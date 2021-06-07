package com.example.weatherdemopractical.core.di

import androidx.room.Room
import com.example.weatherdemopractical.core.database.WeatherDatabase
import com.example.weatherdemopractical.core.network.VolleySingleton
import com.example.weatherdemopractical.map.viewmodel.MapViewModel
import com.example.weatherdemopractical.service.network.WeatherApiService
import com.example.weatherdemopractical.usecase.AddBookmarkUseCase
import com.example.weatherdemopractical.usecase.GetBookmarksUseCase
import com.example.weatherdemopractical.usecase.GetWeatherUseCase
import com.example.weatherdemopractical.usecase.RemoveBookmarkUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(androidApplication(), WeatherDatabase::class.java, "WEATHER_DB")
            .build()
    }
    single { get<WeatherDatabase>().bookmarkDao }

    single {
        VolleySingleton(
            androidApplication()
        )
    }

    single {
        WeatherApiService()
    }

    single {
        GetWeatherUseCase(get())
    }

    single {
        AddBookmarkUseCase(get())
    }

    single {
        RemoveBookmarkUseCase(get())
    }

    single {
        GetBookmarksUseCase(get())
    }

    viewModel { MapViewModel(get(), get(), get(), get()) }
}

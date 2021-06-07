package com.example.weatherdemopractical

import android.app.Application
import com.android.volley.RequestQueue
import com.example.weatherdemopractical.core.di.appModule
import com.example.weatherdemopractical.core.network.VolleySingleton
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        com.example.weatherdemopractical.WeatherApplication.Companion.volleyRequestQue = VolleySingleton.getInstance(applicationContext).requestQueue

        startKoin {
            androidContext(this@WeatherApplication)
            modules(appModule)
        }
    }

    companion object {
        lateinit var volleyRequestQue: RequestQueue
    }
}

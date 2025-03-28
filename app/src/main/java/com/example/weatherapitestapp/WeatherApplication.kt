package com.example.weatherapitestapp

import android.app.Application
import com.example.weatherapitestapp.di.NetWorkModule
import com.example.weatherapitestapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApplication)
            modules(appModule, NetWorkModule)
        }
    }
}
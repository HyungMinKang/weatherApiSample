package com.example.weatherapitestapp.data.reposiitory

import com.example.weatherapitestapp.data.remote.weather.WeatherRemoteDataSource
import com.example.weatherapitestapp.domain.weather.WeatherRepository

class WeatherRepositoryImpl(private val weatherRemoteDataSource: WeatherRemoteDataSource): WeatherRepository {
}
package com.example.weatherapitestapp.di

import com.example.weatherapitestapp.common.Constants
import com.example.weatherapitestapp.data.remote.ipinfo.IpinfoApi
import com.example.weatherapitestapp.data.remote.ipinfo.IpinfoDataSource
import com.example.weatherapitestapp.data.remote.ipinfo.IpinfoRemoeteDataSource
import com.example.weatherapitestapp.data.remote.weather.WeatherApi
import com.example.weatherapitestapp.data.remote.weather.WeatherDataSource
import com.example.weatherapitestapp.data.remote.weather.WeatherRemoteDataSource
import com.example.weatherapitestapp.data.reposiitory.IpinfoRepostiroyImpl
import com.example.weatherapitestapp.data.reposiitory.WeatherRepositoryImpl
import com.example.weatherapitestapp.domain.weather.IpinfoRepository
import com.example.weatherapitestapp.domain.weather.WeatherRepository
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val NetWorkModule = module {


    //Retrofit Module
    single<OkHttpClient>() {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>(named("Interceptor")))
            .build()
    }

    single<Interceptor>(named("Interceptor")) {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    //Weather API
    single<Retrofit>(named("OpenWeather")) {
        Retrofit.Builder()
            .baseUrl(Constants.OPEN_WEATHER_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(get())
            .build()
    }



    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    single<WeatherDataSource> { WeatherRemoteDataSource(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    //IpInfo Api

    single<Retrofit>(named("Ipinfo")) {
        Retrofit.Builder()
            .baseUrl(Constants.IP_INFO_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(get())
            .build()
    }


    single<IpinfoApi> {
        get<Retrofit>().create(IpinfoApi::class.java)
    }

    single<IpinfoDataSource> { IpinfoRemoeteDataSource(get()) }
    single<IpinfoRepository> { IpinfoRepostiroyImpl(get()) }

}
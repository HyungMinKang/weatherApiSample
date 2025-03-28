package com.example.weatherapitestapp.data.remote.ipinfo

import com.example.weatherapitestapp.data.dto.IpinfoDTO
import retrofit2.http.GET

interface IpinfoApi {

    @GET("json")
    suspend fun getLocation(): IpinfoDTO
}
package com.example.weatherapitestapp.domain.weather

import com.example.weatherapitestapp.domain.model.IpInfo

interface IpinfoRepository {
    suspend fun getIpInfo(): IpInfo
}
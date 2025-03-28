package com.example.weatherapitestapp.data.remote.ipinfo

import com.example.weatherapitestapp.data.dto.IpinfoDTO

interface IpinfoDataSource {
    suspend fun getIpInfo(): IpinfoDTO
}
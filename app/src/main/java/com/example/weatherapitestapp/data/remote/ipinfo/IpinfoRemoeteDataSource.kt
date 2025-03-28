package com.example.weatherapitestapp.data.remote.ipinfo

import com.example.weatherapitestapp.data.dto.IpinfoDTO

class IpinfoRemoeteDataSource(private val api: IpinfoApi):IpinfoDataSource {
    override suspend fun getIpInfo(): IpinfoDTO {
        return api.getLocation()
    }
}
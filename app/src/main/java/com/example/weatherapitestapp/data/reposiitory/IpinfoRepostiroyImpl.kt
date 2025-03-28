package com.example.weatherapitestapp.data.reposiitory

import com.example.weatherapitestapp.data.dto.toIpinfo
import com.example.weatherapitestapp.data.remote.ipinfo.IpinfoDataSource
import com.example.weatherapitestapp.domain.model.IpInfo
import com.example.weatherapitestapp.domain.weather.IpinfoRepository

class IpinfoRepostiroyImpl(private val dataSource: IpinfoDataSource):IpinfoRepository {
    override suspend fun getIpInfo(): IpInfo {
        return dataSource.getIpInfo().toIpinfo()
    }
}
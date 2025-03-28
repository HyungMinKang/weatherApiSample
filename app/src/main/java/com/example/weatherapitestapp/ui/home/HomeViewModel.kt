package com.example.weatherapitestapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapitestapp.domain.model.IpInfo
import com.example.weatherapitestapp.domain.weather.IpinfoRepository
import com.example.weatherapitestapp.domain.weather.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val weatherRepository: WeatherRepository, private val ipinfoRepository: IpinfoRepository) : ViewModel(){

    private val _locationInformationStateFlow = MutableStateFlow<IpInfo?>(null)
    val locationInformationStateFlow= _locationInformationStateFlow.asStateFlow()

    fun loadLocationInformation(){
        viewModelScope.launch {
            _locationInformationStateFlow.emit(ipinfoRepository.getIpInfo())
        }
    }

}
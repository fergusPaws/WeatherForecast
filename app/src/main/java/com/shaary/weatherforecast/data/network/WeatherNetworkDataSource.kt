package com.shaary.weatherforecast.data.network

import androidx.lifecycle.LiveData
import com.shaary.weatherforecast.data.network.response.CurrentWeatherResponse
import com.shaary.weatherforecast.data.network.response.FutureWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    // Updates downloaded currentWeatherEntry weather
    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )

    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )
}
package com.shaary.weatherforecast.data.network.response


import com.google.gson.annotations.SerializedName
import com.shaary.weatherforecast.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)
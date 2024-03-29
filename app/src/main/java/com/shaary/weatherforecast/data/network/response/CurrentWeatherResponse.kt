package com.shaary.weatherforecast.data.network.response

import com.google.gson.annotations.SerializedName
import com.shaary.weatherforecast.data.db.entity.CurrentWeatherEntry
import com.shaary.weatherforecast.data.db.entity.WeatherLocation


data class CurrentWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)
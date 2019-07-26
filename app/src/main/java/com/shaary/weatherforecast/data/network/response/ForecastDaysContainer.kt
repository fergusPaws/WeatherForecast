package com.shaary.weatherforecast.data.network.response


import com.google.gson.annotations.SerializedName
import com.shaary.weatherforecast.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)
package com.shaary.weatherforecast.data.db.entity


import com.google.gson.annotations.SerializedName

data class Astro(
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)
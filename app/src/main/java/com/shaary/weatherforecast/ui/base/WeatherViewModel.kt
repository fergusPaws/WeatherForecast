package com.shaary.weatherforecast.ui.base

import androidx.lifecycle.ViewModel
import com.shaary.weatherforecast.data.provider.UnitProvider
import com.shaary.weatherforecast.data.repository.ForecastRepository
import com.shaary.weatherforecast.internal.UnitSystem
import com.shaary.weatherforecast.internal.lazyDeferred

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}
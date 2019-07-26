package com.shaary.weatherforecast.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.shaary.weatherforecast.data.provider.UnitProvider
import com.shaary.weatherforecast.data.repository.ForecastRepository
import com.shaary.weatherforecast.internal.UnitSystem
import com.shaary.weatherforecast.internal.lazyDeferred
import com.shaary.weatherforecast.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }

}

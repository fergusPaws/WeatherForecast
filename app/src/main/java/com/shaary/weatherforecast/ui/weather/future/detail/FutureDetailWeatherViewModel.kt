package com.shaary.weatherforecast.ui.weather.future.detail

import androidx.lifecycle.ViewModel;
import com.shaary.weatherforecast.data.provider.UnitProvider
import com.shaary.weatherforecast.data.repository.ForecastRepository
import com.shaary.weatherforecast.internal.lazyDeferred
import com.shaary.weatherforecast.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
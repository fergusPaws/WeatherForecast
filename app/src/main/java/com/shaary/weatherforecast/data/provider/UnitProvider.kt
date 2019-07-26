package com.shaary.weatherforecast.data.provider

import com.shaary.weatherforecast.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}
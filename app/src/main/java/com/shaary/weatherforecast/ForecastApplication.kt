package com.shaary.weatherforecast

import android.app.Application
import android.content.Context
import androidx.preference.PreferenceManager
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import com.shaary.weatherforecast.data.db.ForecastDatabase
import com.shaary.weatherforecast.data.network.*
import com.shaary.weatherforecast.data.provider.LocationProvider
import com.shaary.weatherforecast.data.provider.LocationProviderImpl
import com.shaary.weatherforecast.data.provider.UnitProvider
import com.shaary.weatherforecast.data.provider.UnitProviderImpl
import com.shaary.weatherforecast.data.repository.ForecastRepository
import com.shaary.weatherforecast.data.repository.ForecastRepositoryImpl
import com.shaary.weatherforecast.ui.weather.current.CurrentWeatherViewModelFactory
import com.shaary.weatherforecast.ui.weather.future.detail.FutureDetailWeatherViewModelFactory
import com.shaary.weatherforecast.ui.weather.future.list.FutureListWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*
import org.threeten.bp.LocalDate

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance(), instance(), instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
        bind() from factory { detailDate: LocalDate -> FutureDetailWeatherViewModelFactory(detailDate, instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        // On start always shows default values
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}
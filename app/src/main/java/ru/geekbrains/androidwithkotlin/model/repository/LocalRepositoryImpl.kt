package ru.geekbrains.androidwithkotlin.model.repository

import ru.geekbrains.androidwithkotlin.model.data.Weather
import ru.geekbrains.androidwithkotlin.model.data.convertHistoryEntityToWeather
import ru.geekbrains.androidwithkotlin.model.data.convertWeatherToEntity
import ru.geekbrains.androidwithkotlin.room.HistoryDao

class LocalRepositoryImpl(private val localDataSource: HistoryDao) : LocalRepository {
    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        return localDataSource.insert(convertWeatherToEntity(weather))
    }
}
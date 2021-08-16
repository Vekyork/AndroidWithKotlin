package ru.geekbrains.androidwithkotlin.model.repository

import ru.geekbrains.androidwithkotlin.model.data.Weather

interface LocalRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}
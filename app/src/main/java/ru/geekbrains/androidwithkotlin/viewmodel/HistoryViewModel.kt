package ru.geekbrains.androidwithkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidwithkotlin.app.App.Companion.getHistoryDao
import ru.geekbrains.androidwithkotlin.model.AppState
import ru.geekbrains.androidwithkotlin.model.repository.LocalRepository
import ru.geekbrains.androidwithkotlin.model.repository.LocalRepositoryImpl

class HistoryViewModel(
    val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val historyRepository: LocalRepository = LocalRepositoryImpl(getHistoryDao())
) : ViewModel() {

    fun getAllHistory(){
        historyLiveData.value = AppState.Loading
        historyLiveData.value = AppState.Success(historyRepository.getAllHistory())
    }
}
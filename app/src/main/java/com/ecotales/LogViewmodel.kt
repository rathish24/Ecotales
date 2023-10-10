package com.ecotales

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LogViewmodel(application: Application):AndroidViewModel(application) {
    private val repository: LogRepository
    val allEntities: LiveData<List<LogEntity>>

    init {
        val logDao = AppDatabase.getInstance(application).logDao()
        repository = LogRepository(logDao)
        allEntities = repository.logEntities
    }


    fun insert(logEntity: LogEntity) = viewModelScope.launch {
        repository.insert(logEntity)
    }
}
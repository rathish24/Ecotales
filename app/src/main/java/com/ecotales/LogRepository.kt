package com.ecotales

import androidx.lifecycle.LiveData



class LogRepository(private val logDao: LogDao) {

    val logEntities: LiveData<List<LogEntity>> = logDao.getLogs()


    suspend fun insert(logEntity: LogEntity) {
        logDao.insertLog(logEntity)
    }
}
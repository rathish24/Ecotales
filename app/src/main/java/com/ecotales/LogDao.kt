package com.ecotales

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.concurrent.Flow


@Dao
interface LogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLog(note: LogEntity)

    @Query("SELECT * FROM LOG_TABLE ")
    fun getLogs(): LiveData<List<LogEntity>>

    @Update
    suspend fun updateNote(note: LogEntity)

    @Delete
    suspend fun deleteNote(note: LogEntity)

    @Insert
    fun insertAll(logs: List<LogEntity>)

}
package com.ecotales

import androidx.room.*
import java.util.concurrent.Flow


@Dao
interface LogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: LogEntity)

    @Query("SELECT * FROM notes ORDER BY dateAdded DESC")
    fun getNotes(): MutableList<LogEntity>

    @Update
    suspend fun updateNote(note: LogEntity)

    @Delete
    suspend fun deleteNote(note: LogEntity)

    @Insert
    fun insertAll(logs: List<LogEntity>)

}
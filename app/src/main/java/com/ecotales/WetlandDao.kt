package com.ecotales

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WetlandDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWetland(wetland: WetlandEntity)

    @Query("SELECT * FROM WETLAND_TABLE")
    fun getWetland(): LiveData<List<WetlandEntity>>

    @Update
    suspend fun updateWetland(wetland: WetlandEntity)

    @Delete
    suspend fun deleteWetland(wetland: WetlandEntity)

    @Insert
    fun insertAll(wetlands: List<WetlandEntity>)
}
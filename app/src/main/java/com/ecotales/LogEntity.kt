package com.ecotales

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LOG_TABLE")
data class LogEntity(
    @PrimaryKey(autoGenerate = false)
    val logId :Int,
    @ColumnInfo(name = "log_place")
    val logPlace:String,
    @ColumnInfo(name = "log_district")
    val logDistrict : String,
    @ColumnInfo(name = "log_observation")
    val logObservations : String
)
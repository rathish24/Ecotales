package com.ecotales

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LOG_TABLE")
data class LogEntity(
    @PrimaryKey(autoGenerate = true)
    val logId :Int,
    @ColumnInfo(name = "log_title")
    val logTitle:String,
    @ColumnInfo(name = "log_desc")
    val logDesc : String
)
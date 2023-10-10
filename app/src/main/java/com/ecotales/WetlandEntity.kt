package com.ecotales

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WETLAND_TABLE")
data class WetlandEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "ramsarSite")
    val ramsarSite: Boolean,
    @ColumnInfo(name = "district")
    val district: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "latitude")
    val latitude: Double,
    @ColumnInfo(name = "longitude")
    val longitude: Double,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "image")
val image: String
)
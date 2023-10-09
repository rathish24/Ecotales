package com.ecotales

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Database(entities = [WetlandEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

  //  abstract val wetlandDao:WetlandDao
    abstract fun wetlandDao(): WetlandDao

    companion object {
        private const val PREFS_NAME = "database_prefs"
        private const val KEY_DATA_POPULATED = "data_populated"

        @Volatile
        private var INSTANCE: AppDatabase? = null



        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "AppDatabase"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }

//        fun getInstance(context: Context): AppDatabase? {
//            return INSTANCE ?: synchronized(this) {
//                val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
//
//                val isDataPopulated = prefs.getBoolean(KEY_DATA_POPULATED, false)
//
//                val instance = (if (!isDataPopulated) roomCallback else null)?.let {
//                    Room.databaseBuilder(
//                        context.applicationContext,
//                        AppDatabase::class.java,
//                        "app_database"
//                    )
//                        .addCallback(it)
//                        .build()
//                }
//
//                if (!isDataPopulated) {
//                    prefs.edit {
//                        putBoolean(KEY_DATA_POPULATED, true)
//                    }
//                }
//
//                INSTANCE = instance
//                instance
//            }
  //      }


        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // Prepopulate data when the database is created
print("roomCallback called :::::")
                val wetlands = listOf(
//

                    WetlandEntity(
                        -1,
                        "Karaivetti Birds Sanctuary",
                        false,
                        "Ariyalur",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land"
                    ),
                    WetlandEntity(
                        -1,
                        "Karaivetti Birds Sanctuary",
                        false,
                        "Ariyalur",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land"
                    )

                )
                INSTANCE?.let { _ ->
                    val wetlandDao = INSTANCE?.wetlandDao()

                    GlobalScope.launch {
                        wetlandDao?.insertAll(wetlands)
                    }
                }
            }
        }
    }


}

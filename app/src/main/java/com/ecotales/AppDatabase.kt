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


@Database(entities = [WetlandEntity::class, LogEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    //  abstract val wetlandDao:WetlandDao
    abstract fun wetlandDao(): WetlandDao
    abstract fun logDao(): LogDao

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
                        1,
                        "Karaivetti Birds Sanctuary",
                        false,
                        "Ariyalur",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "The Karaivetti Bird Sanctuary is a 4.537-square-kilometre protected area located in the Ariyalur District of the state of Tamil Nadu, India. The sanctuary is about 25 kilometres from Thanjavur. This freshwater lake is fed by Pullambadi, Kattalal canal and attracts thousands of birds every year",
                        image = "https://static.toiimg.com/thumb/msid-74385994,width-400,resizemode-4/74385994.jpg"
                    ),
                    WetlandEntity(
                        2,
                        "Otteri Lake",
                        false,
                        "Chengalpattu",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "The Otteri lake is situated inside Arignar Anna Zoological Park in Vandalur near Chennai city With nearly 21 species of birds, the Otteri lake is now turning out to be a bird watcher's paradise This has been a remarkable turnaround for the waterbody that had dried up totally until it was restored about three months ago ",
                        image = "https://static.toiimg.com/thumb/msid-73004070,width-400,resizemode-4/73004070.jpg"
                    ),
                    WetlandEntity(
                        3,
                        "Pichavaram Mangrove",
                        false,
                        "Cuddalore",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "Pichavaram is a village near Chidambaram in Cuddalore District, Tamil Nadu, India. It is located between the Vellar estuary in the north and Coleroon estuary in the south. The Vellar-Coleroon estuarine complex forms the Killai backwater and the mangroves that are permanently rooted in a few feet of water.",
                        image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/4c/3f/63/pichavaram-mangrove-forest.jpg?w=1200&h=-1&s=1"
                    ),
                    WetlandEntity(
                        4,
                        "Chitrangudi Bird Sanctuary\n",
                        false,
                        "Ramanathapuram",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "Chitrangudi Bird Sanctuary locally known as \"Chitrangudi Kanmoli\" is a .4763 km2 (0.1839 sq mi) Protected area declared in 1989 and a part of Chitrangudi village, Mudukulathur Taluk, Ramanathapuram District, Tamil Nadu, India. It is adjacent to Kanjirankulam Bird Sanctuary. It is notable as a nesting site for several migratory heron species that roost in the prominent growth of Babul trees there. International name: Chitragudi and Kanjirankulam Bird Sanctuary, IBA Code: IN261, Criteria: A1, A4i.[2] The sanctuary has been designated as a protected Ramsar site since 2021.",
                        image = "https://www.trawell.in/admin/images/upload/196833669Koonthukulam_Bird_Sanctuary.jpg"
                    ),
                    WetlandEntity(
                        5,
                        "Pidarankari",
                        false,
                        "Dindugal",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "Coming soon",
                        image = "https://www.trawell.in/admin/images/upload/196833669Koonthukulam_Bird_Sanctuary.jpg"
                    ),
                    WetlandEntity(
                        6,
                        "Keelmadai Kulam",
                        false,
                        "Dindugal",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "Coming soon",
                        image = "https://www.trawell.in/admin/images/upload/196833669Koonthukulam_Bird_Sanctuary.jpg"
                    ),

                    WetlandEntity(
                        7,
                        "Vellode Bird Sanctuary",
                        false,
                        "Erode",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "Vellode Birds Sanctuary is a bird sanctuary located in Erode District, Tamil Nadu, India. The sanctuary covers an area of .77 km². The sanctuary is located near Vellode, about 12 km from Erode. It has been designated as a protected Ramsar site since 2022.",
                        image = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/06/25/29/db/vellode-bird-sanctuary.jpg?w=1200&h=1200&s=1"
                    ),
                    WetlandEntity(
                        8,
                        "Vaduvoor Birds Sanctuary",
                        false,
                        "Cuddalore",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "Vaduvoor Bird Sanctuary is a 128.10-hectare area located in Vaduvoor lake, Mannargudi Taluk, Thiruvarur District, Tamil Nadu, India. The sanctuary is about 25 kilometers from Thanjavur and 14 kilometers from Mannargudi on the Thanjavur-Kodiakkarai State Highway 63. It was created in the year 1999. The irrigation tank receives water from November to April every year which attracts numerous foreign birds from Europe and America. The sanctuary attracts more than 40 species of water birds like the white ibis, painted stork, grey pelican, pintails, cormorants, teals, herons, spoonbills, darters, coots, Open bill storks, and pheasant–tailed jacana. The sanctuary is a favorite spot for the migratory birds and during the months of November and December more than 20000 winged visitors reach this area. The sanctuary has basic facilities for tourists to stay overnight and enjoy watching the birds from the two watch towers.",
                        image = "https://en.wikipedia.org/wiki/Vaduvoor_Bird_Sanctuary#/media/File:Vaduvur_4.JPG"
                    ),
                    WetlandEntity(
                        9,
                        "Koonthakulam Bird Sanctuary",
                        false,
                        "Tirunelveli",
                        latitude = 1.5,
                        longitude = 1.5,
                        type = "Costal Land",
                        description = "This sanctuary is actively protected and managed by the Koonthankulam village community. The local people take a keen interest in protecting this sanctuary.\n" +
                                "\n" +
                                "Birds coming to villagers' backyards are protected vehemently and regarded as harbingers of luck. The guano and silt from the tanks is collected by villagers in summer and applied as fertilizer to their fields. All villagers protect the birds, their nests and fledgelings. Fallen chicks are taken care of in the rescue centre till they are able to fly on their own. The Indian festival Diwali is not celebrated here because the sound of crackers would drive away the winged visitors.\n" +
                                "\n" +
                                "An interpretation centre, watch tower, children's park and dormitory are open for public use throughout the year.",
                        image = "https://www.trawell.in/admin/images/upload/196833669Koonthukulam_Bird_Sanctuary.jpg"
                    ),


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

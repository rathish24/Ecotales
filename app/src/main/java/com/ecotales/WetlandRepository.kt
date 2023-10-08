package com.ecotales

import androidx.lifecycle.LiveData



class WetlandRepository(private val wetlandDao: WetlandDao) {

    val wetlandEntitys: LiveData<List<WetlandEntity>> = wetlandDao.getWetland()


//    fun insert(yourEntity: YourEntity) {
//        // Perform database operations on a background thread
//        viewModelScope.launch {
//            yourEntityDao.insertEntity(yourEntity)
//        }
//    }
}
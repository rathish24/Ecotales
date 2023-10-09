package com.ecotales

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class WetlandViewmodel(application: Application):AndroidViewModel(application) {
    private val repository: WetlandRepository
    val allEntities: LiveData<List<WetlandEntity>>

    init {
        val userDao = AppDatabase.getInstance(application).wetlandDao()
        repository = WetlandRepository(userDao)
        allEntities = repository.wetlandEntitys
    }

//
//    fun insert(yourEntity: YourEntity) {
//        repository.insert(yourEntity)
//    }
}
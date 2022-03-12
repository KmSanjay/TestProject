package com.example.testproject.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.repo.RoomRepository
import com.example.testproject.room.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RoomRepository) : ViewModel() {
    lateinit var userData: MutableLiveData<List<UserEntity>>

    init {
        userData = MutableLiveData()
        loadReconds()
    }

    fun getRecordsObserver(): MutableLiveData<List<UserEntity>> {
        return userData
    }

    fun loadReconds() {
        val list = repository.getAllUser()
        userData.postValue(list)
    }



    fun insertRecords(userEntity: UserEntity) {
        repository.insertRecord(userEntity)
        loadReconds()
    }

}
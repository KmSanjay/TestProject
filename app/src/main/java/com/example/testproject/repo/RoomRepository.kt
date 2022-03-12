package com.example.testproject.repo

import com.example.testproject.room.AppDao
import com.example.testproject.room.UserEntity
import javax.inject.Inject

class RoomRepository @Inject constructor(val appDao: AppDao) {

    fun getAllUser():List<UserEntity>{
        return appDao.getAllUser()
    }

    fun insertRecord(userEntity: UserEntity){
      appDao.insertRecord(userEntity)
    }
}
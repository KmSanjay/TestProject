package com.example.testproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM user_table ORDER BY id DESC")
    fun getAllUser():List<UserEntity>

    @Insert
    fun insertRecord(userEntity: UserEntity)
}
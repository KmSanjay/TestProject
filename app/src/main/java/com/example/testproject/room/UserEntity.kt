package com.example.testproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id: Int = 0,
    @ColumnInfo(name = "user_name") var name: String,
    @ColumnInfo(name = "address") var address: String,
    @ColumnInfo(name = "phone") var phone: String,
    @ColumnInfo(name = "email") var email: String,

    )

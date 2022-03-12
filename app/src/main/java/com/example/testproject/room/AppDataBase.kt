package com.example.testproject.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getDao():AppDao

    companion object {
        private var INSTANCE:AppDataBase?=null

        fun getDataBase(context: Context):AppDataBase{
            if (INSTANCE==null){
                INSTANCE=Room.databaseBuilder<AppDataBase>(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "AppDataBase")
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }
}
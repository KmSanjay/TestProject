package com.example.testproject.di

import android.app.Application
import android.content.Context
import com.example.testproject.room.AppDao
import com.example.testproject.room.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(context: Application):AppDataBase{
        return AppDataBase.getDataBase(context)
    }

    @Singleton
    @Provides
    fun getDao(appDataBase: AppDataBase):AppDao{
        return appDataBase.getDao()
    }
}
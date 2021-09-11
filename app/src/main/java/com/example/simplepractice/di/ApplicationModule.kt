package com.example.simplepractice.di

import android.content.Context
import androidx.room.Room
import com.example.simplepractice.model.db.StudentDao
import com.example.simplepractice.model.db.StudentDb
import com.example.simplepractice.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ):StudentDb{
        return Room.databaseBuilder(context,StudentDb::class.java,"app_db").build()
    }

    @Provides
    @Singleton
    fun provideStudentDao(studentDb: StudentDb):StudentDao{
        return studentDb.getStudentDao()
    }
}
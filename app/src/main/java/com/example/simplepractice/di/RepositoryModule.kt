package com.example.simplepractice.di

import com.example.simplepractice.model.dataSource.LocalDataSource
import com.example.simplepractice.model.dataSource.RemoteDataSource
import com.example.simplepractice.model.db.StudentDao
import com.example.simplepractice.model.repo.StudentRepository
import com.example.simplepractice.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideStudentRepository(
        apiService: ApiService,
        studentDao: StudentDao
    ): StudentRepository {
        return StudentRepository(RemoteDataSource(apiService), LocalDataSource(studentDao))
    }
}
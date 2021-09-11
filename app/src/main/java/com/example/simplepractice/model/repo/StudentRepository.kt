package com.example.simplepractice.model.repo

import com.example.simplepractice.model.dataClass.Student
import com.example.simplepractice.model.dataSource.LocalDataSource
import com.example.simplepractice.model.dataSource.RemoteDataSource
import com.example.simplepractice.util.networkBoundResource
import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Inject

class StudentRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): Repository {

    fun getStudents() = networkBoundResource(
        query = {
            localDataSource.getStudentList()
        },
        fetch = {
            delay(2000)
            remoteDataSource.getStudents()
        },
        saveFetchResult = {
            localDataSource.deleteStudentList()
            localDataSource.addStudent(it)
        }
    )

    suspend fun addStudent(firstName:String,lastName:String,course:String,score:String):Student{
//        try {
            return remoteDataSource.addStudent(firstName,lastName,course,score.toInt())
//        }catch (e:Exception){
//            Timber.e("error-> $e")
//        }
    }

    suspend fun addNewStudentToDb(student: Student){
        localDataSource.addNewStudent(student)
    }
}
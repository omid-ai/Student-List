package com.example.simplepractice.model.dataSource

import com.example.simplepractice.model.dataClass.Student
import com.example.simplepractice.model.db.StudentDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val studentDao: StudentDao
) {

    fun getStudentList(): Flow<List<Student>> =
        studentDao.getStudent()

    suspend fun addStudent(student: List<Student>) {
        studentDao.addStudent(student)
    }

    suspend fun deleteStudentList() {
        studentDao.deleteExpiredData()
    }

    suspend fun addNewStudent(student: Student){
        studentDao.addNewStudent(student)
    }
}
package com.example.simplepractice.model.dataSource

import com.example.simplepractice.model.dataClass.Student
import com.example.simplepractice.service.ApiService
import com.google.gson.JsonObject
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getStudents(): List<Student> =
        apiService.fetchStudents()

    suspend fun addStudent(firstName:String,lastName:String,course:String,score:Int): Student =
        apiService.addStudent(JsonObject().apply {
            addProperty("first_name", firstName)
            addProperty("last_name", lastName)
            addProperty("course", course)
            addProperty("score", score)
        })

}
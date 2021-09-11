package com.example.simplepractice.service

import com.example.simplepractice.model.dataClass.Student
import com.google.gson.JsonObject
import retrofit2.http.*

interface ApiService {

    @GET("experts/student")
    suspend fun fetchStudents():List<Student>

    @POST("experts/student")
    suspend fun addStudent(
        @Body jsonObject: JsonObject
    ):Student
}
package com.example.simplepractice.model.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    val course: String,
    val first_name: String,
    @PrimaryKey
    val id: Int?,
    val last_name: String,
    val score: Int
)
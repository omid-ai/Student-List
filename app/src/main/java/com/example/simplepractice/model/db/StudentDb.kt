package com.example.simplepractice.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplepractice.model.dataClass.Student

@Database(entities = [Student::class],version = 1,exportSchema = true)
abstract class StudentDb:RoomDatabase() {
    abstract fun getStudentDao():StudentDao
}
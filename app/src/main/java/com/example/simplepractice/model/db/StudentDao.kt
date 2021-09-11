package com.example.simplepractice.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplepractice.model.dataClass.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Query("SELECT * FROM student")
    fun getStudent():Flow<List<Student>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(student: List<Student>)

    @Query("DELETE FROM student")
    suspend fun deleteExpiredData()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewStudent(student: Student)
}
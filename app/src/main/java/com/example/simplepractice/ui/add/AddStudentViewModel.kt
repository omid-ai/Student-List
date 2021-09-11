package com.example.simplepractice.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplepractice.model.dataClass.Student
import com.example.simplepractice.model.repo.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStudentViewModel @Inject constructor(
    private val studentRepository: StudentRepository
):ViewModel() {

    fun addStudent(firstName:String,lastName:String,course:String,score:String){
        viewModelScope.launch {
            val student=async {
                studentRepository.addStudent(firstName,lastName,course,score)
            }
            studentRepository.addNewStudentToDb(student.await())
        }
    }
}
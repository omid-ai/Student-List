package com.example.simplepractice.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.simplepractice.model.repo.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val studentRepository: StudentRepository
):ViewModel() {

    val student=studentRepository.getStudents().asLiveData()

}
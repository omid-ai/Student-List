package com.example.simplepractice.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.simplepractice.databinding.ActivityAddStudentFormBinding
import com.example.simplepractice.model.dataClass.Student
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStudentFormActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddStudentFormBinding
    val viewModel:AddStudentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddStudentFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doneBtn.setOnClickListener {
            viewModel.addStudent(
                binding.firstNameEt.text.toString(),
                binding.lastNameEt.text.toString(),
                binding.courseEt.text.toString(),
                binding.scoreEt.text.toString()
            )
        }
    }
}
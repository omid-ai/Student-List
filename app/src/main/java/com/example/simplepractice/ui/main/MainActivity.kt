package com.example.simplepractice.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplepractice.databinding.ActivityMainBinding
import com.example.simplepractice.ui.add.AddStudentFormActivity
import com.example.simplepractice.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()
    val adapter= MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        binding.addStudentBtn.setOnClickListener {
            startActivity(Intent(this, AddStudentFormActivity::class.java))
        }

        viewModel.student.observe(this){
            Timber.i("list of students-> ${it.data}")
            adapter.submitList(it.data)
            binding.rvMain.adapter=adapter
            binding.progressBarMain.isVisible=it is Resource.Loading && it.data.isNullOrEmpty()
            binding.textViewError.isVisible = it is Resource.Error && it.data.isNullOrEmpty()
            binding.textViewError.text = it.error?.localizedMessage
        }
    }
}
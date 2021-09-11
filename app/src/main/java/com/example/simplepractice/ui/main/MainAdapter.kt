package com.example.simplepractice.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simplepractice.databinding.ItemStudentBinding
import com.example.simplepractice.model.dataClass.Student

class MainAdapter: ListAdapter<Student, MainAdapter.ViewHolder>(StudentComparator()) {

    lateinit var binding: ItemStudentBinding

    inner class ViewHolder(binding: ItemStudentBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bindStudents(student: Student){
            binding.courseTv.text=student.course
            binding.fullNameTv.text=student.first_name+student.last_name
            binding.gradeTv.text=student.score.toString()
            binding.firstLetterTv.text=student.first_name.substring(0,1)
        }
    }

    class StudentComparator: DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean =
            oldItem.id==newItem.id


        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean =
            oldItem==newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding= ItemStudentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bindStudents(currentItem)
        }
    }
}
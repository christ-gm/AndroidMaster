package com.eltulita.androidmaster.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eltulita.androidmaster.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategoryName:TextView = view.findViewById(R.id.tvCategoryName)
    private val divider:TextView = view.findViewById(R.id.divider)
    fun render(taskCategory: TaskCategory){
        tvCategoryName.text = "Ejemplo"
    }
}
package com.example.mvvm_android

import com.example.mvvm_android.room_database.User
import com.example.mvvm_android.to_do_list.ToDoData

interface OnItemClickListener {
    fun onItemEdit(toDoData: ToDoData)
    fun onItemDelete(toDoData: ToDoData)
}
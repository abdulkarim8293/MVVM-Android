package com.example.mvvm_android

import com.example.mvvm_android.room_database.User

interface OnItemClickListener {
    fun onItemEdit(user: User)
    fun onItemDelete(user: User)
}
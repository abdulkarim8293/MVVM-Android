package com.example.mvvm_android.to_do_list

import androidx.room.*
import com.example.mvvm_android.room_database.User

@Dao
interface ToDoDao {

    @Insert
    suspend fun insertToDo(toDoData: ToDoData)

    @Update
    suspend fun updateToDo(toDoData: ToDoData)

    @Delete
    suspend fun deleteToDo(toDoData: ToDoData)

    @Query("SELECT * FROM to_do_table")
    suspend fun loadAllToDo(): List<ToDoData>

}
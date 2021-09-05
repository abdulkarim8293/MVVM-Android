package com.example.mvvm_android.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_android.to_do_list.ToDoDao
import com.example.mvvm_android.to_do_list.ToDoData

@Database(entities = [User::class,ToDoData::class], version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getToDoDao(): ToDoDao

    companion object {
        var INSTANCE:AppDatabase? = null

        fun getInstance(context: Context):AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user.db"
                )
                    .build()
            }
            return INSTANCE
        }

        fun cleanDbObject() {
            INSTANCE = null
        }

    }
}
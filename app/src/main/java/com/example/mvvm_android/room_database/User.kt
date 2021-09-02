package com.example.mvvm_android.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "user_name")
    val name: String?,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String?
) : Serializable
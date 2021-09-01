package com.example.mvvm_android.room_database
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(User: User)

    @Query("SELECT * FROM user_table")
    fun loadAllUser(): List<User>

    @Delete
    fun deleteUser(user: User)


}
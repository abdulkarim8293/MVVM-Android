package com.example.mvvm_android.room_database
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    fun insertUser(User: User)

    @Update
    suspend fun updateUsers(user: User)


    @Query("SELECT * FROM user_table")
    suspend fun loadAllUser(): List<User>

    @Delete
    suspend fun deleteUser(user: User)


}
package com.example.mvvm_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_android.adaptar.UserListAdapter
import com.example.mvvm_android.room_database.User
import com.example.mvvm_android.room_database.AppDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var adapter:UserListAdapter? = null
    private var appDatabase:AppDatabase? = null

    private var userList:List<User> ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDatabase = AppDatabase.getInstance(this)
        val userRecyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val userList = appDatabase?.getUserDao()?.loadAllUser()
            //Log.e("User", "$userList")
            adapter = UserListAdapter(userList)
            userRecyclerView.adapter = adapter

        }

        findViewById<FloatingActionButton>(R.id.addUserFAB).setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))
        }

    }



}
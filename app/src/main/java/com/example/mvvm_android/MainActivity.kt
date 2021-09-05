package com.example.mvvm_android

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_android.adaptar.UserListAdapter
import com.example.mvvm_android.room_database.User
import com.example.mvvm_android.room_database.DB
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var adapter:UserListAdapter? = null
    private var db:DB? = null

    private var userList:List<User> ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DB.getInstance(this)
        val userRecyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val userList = db?.getUserDao()?.loadAllUser()
            //Log.e("User", "$userList")
            adapter = UserListAdapter(userList)
            userRecyclerView.adapter = adapter

        }

        findViewById<FloatingActionButton>(R.id.addUserFAB).setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))
        }

    }



}
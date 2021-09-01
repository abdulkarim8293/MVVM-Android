package com.example.mvvm_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvm_android.room_database.UserDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = UserDatabase.getInstance(this)

        GlobalScope.launch {
            val list = db?.getUserDao()?.loadAllUser()
            Log.e("User", "$list")
        }



        findViewById<FloatingActionButton>(R.id.addUserFAB).setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))
        }

    }
}
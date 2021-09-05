package com.example.mvvm_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mvvm_android.room_database.User
import com.example.mvvm_android.room_database.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val db = AppDatabase.getInstance(this)

        findViewById<Button>(R.id.saveBtn).setOnClickListener {

            val userName:String = findViewById<EditText>(R.id.userNameEt).text.toString()
            val phoneNumber:String = findViewById<EditText>(R.id.userPhoneNumberEt).text.toString()

            if (userName.isEmpty() && phoneNumber.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name and Phone Number",Toast.LENGTH_SHORT).show()

            }else{
                val user = User(0,userName,phoneNumber)
                GlobalScope.launch {
                    db?.getUserDao()?.insertUser(user)
                }

                Log.d("KKKK","User is : $user")
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }
}
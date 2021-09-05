package com.example.mvvm_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.mvvm_android.room_database.User
import com.example.mvvm_android.room_database.DB
import kotlinx.coroutines.launch

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val db = DB.getInstance(this)

        val user: User? = intent.getSerializableExtra("user") as User?


        findViewById<EditText>(R.id.nameEt).setText(user?.name)
        findViewById<EditText>(R.id.phoneEt).setText(user?.phoneNumber)
        findViewById<Button>(R.id.updateUserBtn).setOnClickListener {

            lifecycleScope.launch {
                val name: String = findViewById<EditText>(R.id.nameEt).text.toString()
                val phone: String = findViewById<EditText>(R.id.phoneEt).text.toString()

                if (user != null) {
                    db?.getUserDao()?.updateUsers(User(user.id,name,phone))
                    Toast.makeText(this@UserDetailsActivity, "Success", Toast.LENGTH_SHORT).show()

                }
            }

        }
    }
}
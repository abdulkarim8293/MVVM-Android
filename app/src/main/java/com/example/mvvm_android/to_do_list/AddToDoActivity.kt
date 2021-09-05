package com.example.mvvm_android.to_do_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.mvvm_android.R
import com.example.mvvm_android.room_database.AppDatabase
import kotlinx.coroutines.launch

class AddToDoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        val actionBar = supportActionBar
        actionBar!!.title = "Add To Do"

        val db = AppDatabase.getInstance(this)

        findViewById<Button>(R.id.saveBtn).setOnClickListener {

            val title = findViewById<EditText>(R.id.titleEt).text.toString()
            val description = findViewById<EditText>(R.id.descriptionEt).text.toString()

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please Enter title and description", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val toDoData = ToDoData(0, title, description)

                lifecycleScope.launch {
                    db?.getToDoDao()?.insertToDo(toDoData)
                }
                Toast.makeText(this, "To do data  is : $toDoData", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ToDoListActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            }
        }

        findViewById<ImageView>(R.id.backButtonIv).setOnClickListener {
            startActivity(Intent(this, ToDoListActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }


    }
}
package com.example.mvvm_android.to_do_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.example.mvvm_android.R
import com.example.mvvm_android.room_database.AppDatabase
import kotlinx.coroutines.launch

class UpdateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatae_to_do)

        val actionBar = supportActionBar
        actionBar!!.title = "Update To Do"

        val db = AppDatabase.getInstance(this)

        findViewById<ImageView>(R.id.backButtonIv).setOnClickListener {
            startActivity(Intent(this, ToDoListActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }

        val toDoData:ToDoData = intent.getSerializableExtra("todo") as ToDoData

        findViewById<EditText>(R.id.titleEt).setText(toDoData.title)
        findViewById<EditText>(R.id.descriptionEt).setText(toDoData.description)

        findViewById<Button>(R.id.updateBtn).setOnClickListener {
            val title = findViewById<EditText>(R.id.titleEt).text.toString()
            val description = findViewById<EditText>(R.id.descriptionEt).text.toString()

            lifecycleScope.launch {
                db?.getToDoDao()?.updateToDo(ToDoData(toDoData.id,title,description))
            }

            startActivity(Intent(this, ToDoListActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }



    }
}
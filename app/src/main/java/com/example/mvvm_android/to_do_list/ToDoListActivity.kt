package com.example.mvvm_android.to_do_list

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_android.OnItemClickListener
import com.example.mvvm_android.R
import com.example.mvvm_android.UserDetailsActivity
import com.example.mvvm_android.adaptar.ToDoListAdapter
import com.example.mvvm_android.adaptar.UserListAdapter
import com.example.mvvm_android.room_database.DB
import com.example.mvvm_android.room_database.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch
import kotlin.math.log

class ToDoListActivity : AppCompatActivity(),OnItemClickListener {

    private lateinit var adapter: ToDoListAdapter
    private lateinit var recyclerview: RecyclerView
    private var db:DB? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        db = DB.getInstance(this)

        recyclerview = findViewById(R.id.todo_recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)

        /*lifecycleScope.launch {
            db?.getToDoDao()?.insertToDo(ToDoData(0,"Title 2","Description 2"))
        }*/

        lifecycleScope.launch {
            val list = db?.getToDoDao()?.loadAllToDo()
            adapter = ToDoListAdapter(list,this@ToDoListActivity)
            recyclerview.adapter = adapter
            Log.i("MMM","List size is : $list")
        }

        findViewById<FloatingActionButton>(R.id.addToDoFAB).setOnClickListener {
            startActivity(Intent(this,AddToDoActivity::class.java))
        }


    }

    override fun onItemEdit(toDoData: ToDoData) {
        startActivity(Intent(this, UpdateToDoActivity::class.java).putExtra("todo",toDoData)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

    }

    override fun onItemDelete(toDoData: ToDoData) {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Delete Item")
        builder.setMessage("Are you want to delete this note")

        builder.setPositiveButton("Yes", DialogInterface.OnClickListener{
                dialog, which ->

            lifecycleScope.launch {

                db?.getToDoDao()?.updateToDo(toDoData)
                Toast.makeText(applicationContext,"Item deleted success", Toast.LENGTH_LONG).show()
            }

        })

        builder.setNegativeButton("No"){dialogInterface, which ->
            Toast.makeText(applicationContext,"clicked No", Toast.LENGTH_LONG).show()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }


}
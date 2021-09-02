package com.example.mvvm_android

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_android.adaptar.UserListAdapter
import com.example.mvvm_android.room_database.User
import com.example.mvvm_android.room_database.UserDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),OnItemClickListener {

    private var adapter:UserListAdapter? = null
    private var db:UserDatabase? = null

    private var userList:List<User> ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = UserDatabase.getInstance(this)
        val userRecyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val userList = db?.getUserDao()?.loadAllUser()
            //Log.e("User", "$userList")
            adapter = UserListAdapter(userList,this@MainActivity)
            userRecyclerView.adapter = adapter

        }

        findViewById<FloatingActionButton>(R.id.addUserFAB).setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))
        }

    }

    override fun onItemEdit(user: User) {
        startActivity(Intent(this,UserDetailsActivity::class.java).putExtra("user",user))
    }

    override fun onItemDelete(user: User) {

        val view = findViewById<CoordinatorLayout>(R.id.snackbar_action)
        val snackbar = Snackbar.make(view, "Your Want to Delete", Snackbar.LENGTH_LONG)
            snackbar.setAction("Yes", View.OnClickListener {
                lifecycleScope.launch {
                    db?.getUserDao()?.deleteUser(user)
                    adapter?.notifyDataSetChanged()

                }
            })
        snackbar.show()

        adapter?.notifyDataSetChanged()

    }

}
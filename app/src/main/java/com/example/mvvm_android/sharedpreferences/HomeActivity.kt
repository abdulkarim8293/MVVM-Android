package com.example.mvvm_android.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mvvm_android.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<TextView>(R.id.userNameTv).text = PreferenceManager.username
        Toast.makeText(this, "${PreferenceManager.username}", Toast.LENGTH_SHORT).show()

        findViewById<Button>(R.id.logOutBtn).setOnClickListener {
            PreferenceManager.isLogin = false
            startActivity(Intent(this,LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()
        }
    }
}
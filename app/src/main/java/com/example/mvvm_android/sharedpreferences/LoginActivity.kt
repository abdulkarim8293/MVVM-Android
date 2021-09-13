package com.example.mvvm_android.sharedpreferences

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.mvvm_android.R
import com.example.mvvm_android.bottom_navigation.BottomNavigationActivity

class LoginActivity : AppCompatActivity() {

    var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        PreferenceManager.init(this)

        if(PreferenceManager.isLogin){
            startActivity(Intent(this,HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()
        }

        val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener {

            val userName = findViewById<EditText>(R.id.userNameEt).text.toString()
            val password = findViewById<EditText>(R.id.passwordEt).text.toString()

            if (userName.isEmpty()){
                Toast.makeText(this, "Please Enter Your User Name", Toast.LENGTH_SHORT).show()
            }else if (password.isEmpty()){
                Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show()
            }

            if(PreferenceManager.isLogin){
                PreferenceManager.isLogin = false
            }else{
                PreferenceManager.isLogin = true
                PreferenceManager.username = userName
                PreferenceManager.password = password
                startActivity(Intent(this,HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }

        }

        val password = findViewById<EditText>(R.id.passwordEt)

        password.setDrawableRightTouch {

            Toast.makeText(this, "Right Touch", Toast.LENGTH_SHORT).show()

            if (isPasswordVisible){
                isPasswordVisible = false
                password.transformationMethod = PasswordTransformationMethod.getInstance()
                password.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(this,R.drawable.ic_visibility_off_24), null)
            }else{
                isPasswordVisible = true
                password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                password.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(this,R.drawable.ic_visibility_24), null)
            }

        }





    }

    @SuppressLint("ClickableViewAccessibility")
    fun EditText.setDrawableRightTouch(setClickListener: () -> Unit) {
        this.setOnTouchListener(View.OnTouchListener { _, event ->

            val DRAWABLE_RIGHT = 2

            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= this.right - this.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    setClickListener()
                    return@OnTouchListener true
                }
            }
            false
        })
    }

}
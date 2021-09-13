package com.example.mvvm_android.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.mvvm_android.R
import com.example.mvvm_android.fragments.bottom_nav_fragments.CarsFragment
import com.example.mvvm_android.fragments.bottom_nav_fragments.TripDetailsFragment
import com.example.mvvm_android.fragments.bottom_nav_fragments.TripRequestFragment
import com.example.mvvm_android.fragments.bottom_nav_fragments.WaitingBidFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_notes_24)
        setSupportActionBar(toolbar)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        loadFragment(TripRequestFragment())
        supportActionBar?.title = "ট্রিপ রিকোয়েস্ট"

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.trip_request_nav -> {
                    loadFragment(TripRequestFragment())
                    supportActionBar?.title = "ট্রিপ রিকোয়েস্ট"
                    true
                }
                R.id.cars_nav -> {
                    loadFragment(CarsFragment())
                    supportActionBar?.title = "গাড়িসমূহ"
                    true
                }
                R.id.waiting_bid_nav -> {
                    loadFragment(WaitingBidFragment())
                    supportActionBar?.title = "অপেক্ষামান বিড"
                    true
                }
                R.id.trip_details_nav -> {
                    loadFragment(TripDetailsFragment())
                    supportActionBar?.title = "ট্রিপের বিবরণ"
                    true
                }
                else -> false
            }
        }
    }


    private fun loadFragment(fragment: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment).commit()
    }
}
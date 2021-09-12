package com.example.mvvm_android.view_pager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.mvvm_android.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val list = listOf<String>(
            "Hello 1","Hello 2","Hello 3","Hello 4","Hello 5"
        )

        val viewPagerAdapter = ViewPagerAdapter(list)

        val dotsIndicator = findViewById<WormDotsIndicator>(R.id.dots_indicator)
        val viewPager = findViewById<ViewPager>(R.id.viewPagerId)

        viewPager.adapter = viewPagerAdapter
        dotsIndicator.setViewPager(viewPager)

    }
}
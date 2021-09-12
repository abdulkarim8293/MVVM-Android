package com.example.mvvm_android.view_pager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.mvvm_android.R


class ViewPagerAdapter(private val list: List<String>) : PagerAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object` as View
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(container?.context)
            .inflate(R.layout.page_layout,container,false)

        val hello:TextView = view.findViewById(R.id.titleTv)

        hello.text = list.get(position)

        container?.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}
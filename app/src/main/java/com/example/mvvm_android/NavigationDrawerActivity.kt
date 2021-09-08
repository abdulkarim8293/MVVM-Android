package com.example.mvvm_android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mvvm_android.databinding.ActivityNavigationDrawerBinding
import com.example.mvvm_android.fragments.GetFragment
import com.example.mvvm_android.fragments.PostFragment
import com.example.mvvm_android.fragments.PutFragment
import com.google.android.material.navigation.NavigationView

class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityNavigationDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout

        binding.appBarNavigationDrawer.toolbar.setNavigationIcon(R.drawable.ic_drop_down_menu_24)

        binding.appBarNavigationDrawer.toolbar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        binding.navView.setNavigationItemSelectedListener(this)

        //loadFragment(GetFragment())


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.drawerLayout.close()
        when(item.itemId){
            R.id.nav_get ->{
                loadFragment(GetFragment(),"Get Request")
                Toast.makeText(this,"Get Method",Toast.LENGTH_SHORT).show()
            }

            R.id.nav_post ->
                loadFragment(PostFragment(),"Post Request")

            R.id.nav_put ->
                loadFragment(PutFragment(),"Put Request")
        }
        return true
    }

    private fun loadFragment(fragment: Fragment,title:String){
        supportActionBar?.title = title
        val fragment = supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container,fragment).commit()
    }

}
package com.example.jeepme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Login/SignUp
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: ""
        val userName = intent.getStringExtra("USER_NAME") ?: ""

        // Load HomeFragment by default
        loadFragment(HomeFragment())

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_saved -> loadFragment(SavedFragment())
                R.id.nav_profile -> {
                    val fragment = ProfileFragment()
                    val bundle = Bundle()
                    bundle.putString("USER_EMAIL", userEmail)
                    bundle.putString("USER_NAME", userName)
                    fragment.arguments = bundle
                    loadFragment(fragment)
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
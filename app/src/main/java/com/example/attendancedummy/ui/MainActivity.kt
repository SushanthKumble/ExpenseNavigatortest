package com.example.attendancedummy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.attendancedummy.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        val role = getCurrentUserRole() // "USER"  "ADMIN"

        // Find the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        if (role == "USER") {
            bottomNavigationView.inflateMenu(R.menu.menu_user)
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph_user)
            navController.graph = navGraph
        } else if (role == "ADMIN") {
            bottomNavigationView.inflateMenu(R.menu.menu_admin)
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph_admin)
            navController.graph = navGraph
        }

        bottomNavigationView.setupWithNavController(navController)
    }

    private fun getCurrentUserRole(): String {
        // Implement your logic to get the current user's role
        return "USER" // or "ADMIN"
    }
}

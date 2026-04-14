package com.example.jeepme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageButton
import android.widget.Button

class RouteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_detail)

        // Receive data passed from HomeFragment
        val routeName = intent.getStringExtra("ROUTE_NAME") ?: "Route"
        val routeFare = intent.getStringExtra("ROUTE_FARE") ?: "13-20"
        val routeStops = intent.getStringExtra("ROUTE_STOPS") ?: ""

        // Set data to views
        findViewById<TextView>(R.id.tvRouteName).text = routeName
        findViewById<TextView>(R.id.tvFare).text = "Fare: $routeFare"
        findViewById<TextView>(R.id.tvStops).text = routeStops

        // Back button
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish() // goes back to previous screen
        }
    }
}
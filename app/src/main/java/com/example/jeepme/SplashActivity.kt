package com.example.jeepme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Wait 2 seconds then go to OptionActivity
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, OptionActivity::class.java))
            finish()
        }, 2000)
    }
}
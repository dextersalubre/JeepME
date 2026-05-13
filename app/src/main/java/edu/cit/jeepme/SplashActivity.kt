package edu.cit.jeepme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import auth.OptionActivity
import home.HomeActivity
import profile.SessionManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val session = SessionManager(this)

        Handler(mainLooper).postDelayed({
            // Check SharedPreferences if user is already logged in
            if (session.isLoggedIn()) {
                // Skip login screen — go directly to Home
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                startActivity(Intent(this, OptionActivity::class.java))
            }
            finish()
        }, 2000)
    }
}
package com.example.jeepme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ProfileEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit)

        // Receive data passed from ProfileFragment
        val userName = intent.getStringExtra("USER_NAME") ?: ""
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: ""

        // Pre-fill the fields
        findViewById<EditText>(R.id.etFullName).setText(userName)
        findViewById<EditText>(R.id.etEmail).setText(userEmail)

        // Back arrow
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Update button
        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
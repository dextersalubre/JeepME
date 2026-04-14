package com.example.jeepme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnCreateAccount).setOnClickListener {
            val fullName = etFullName.text.toString()
            val email = etEmail.text.toString()

            if (fullName.isNotEmpty() && email.isNotEmpty()) {
                // Pass data to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USER_NAME", fullName)
                intent.putExtra("USER_EMAIL", email)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // "I already have an account?" link
        findViewById<TextView>(R.id.tvHaveAccount).setOnClickListener {
            finish() // goes back to OptionActivity
        }
    }
}
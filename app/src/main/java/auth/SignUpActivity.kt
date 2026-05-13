package auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import home.HomeActivity
import edu.cit.jeepme.R
import profile.SessionManager

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val session = SessionManager(this)
        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnCreateAccount).setOnClickListener {
            val fullName = etFullName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (fullName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {

                // SAVE registered credentials to SharedPreferences
                session.saveLoginSession(fullName, email)
                session.saveRegisteredCredentials(email, password)

                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<TextView>(R.id.tvHaveAccount).setOnClickListener {
            finish()
        }
    }
}
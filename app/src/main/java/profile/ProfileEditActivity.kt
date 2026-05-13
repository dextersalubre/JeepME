package profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import edu.cit.jeepme.R

class ProfileEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit)

        val session = SessionManager(this)

        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etNickname = findViewById<EditText>(R.id.etNickname)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)

        // RETRIEVE from SharedPreferences and pre-fill fields
        etFullName.setText(session.getUserName())
        etNickname.setText(session.getNickname())
        etEmail.setText(session.getUserEmail())
        etPhone.setText(session.getPhone())

        // Back button
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // UPDATE SharedPreferences with new values
        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            val newName = etFullName.text.toString()
            val newNickname = etNickname.text.toString()
            val newEmail = etEmail.text.toString()
            val newPhone = etPhone.text.toString()

            if (newName.isNotEmpty() && newEmail.isNotEmpty()) {
                // SAVE updated data to SharedPreferences
                session.updateProfile(newName, newNickname,
                    newEmail, newPhone)
                Toast.makeText(this, "Profile Updated!",
                    Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Name and Email cannot be empty",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
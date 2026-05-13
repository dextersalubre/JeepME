package auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import edu.cit.jeepme.R
import home.HomeActivity
import profile.SessionManager
import utils.showToast  // ← using extension function

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val session = SessionManager(this)
        presenter = LoginPresenter(this, session)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            presenter.onLoginClicked(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }
    }

    override fun showError(message: String) {
        showToast(message)  // ← extension function instead of Toast.makeText(...)
    }

    override fun showEmptyFieldsError() {
        showToast("Please fill all fields")
    }

    override fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
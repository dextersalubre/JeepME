package profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import edu.cit.jeepme.R

class PrivacyPolicyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy)

        // Back arrow
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
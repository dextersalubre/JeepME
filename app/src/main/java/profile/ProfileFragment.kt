package profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import auth.OptionActivity
import edu.cit.jeepme.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_profile,
            container, false)

        val session = SessionManager(requireContext())

        // RETRIEVE data from SharedPreferences and display
        view.findViewById<TextView>(R.id.tvUserName).text =
            session.getUserName()
        view.findViewById<TextView>(R.id.tvUserEmail).text =
            session.getUserEmail()

        // Edit Profile — pass data via Intent
        view.findViewById<LinearLayout>(R.id.menuEditProfile)
            .setOnClickListener {
                val intent = Intent(requireContext(),
                    ProfileEditActivity::class.java)
                intent.putExtra("USER_NAME", session.getUserName())
                intent.putExtra("USER_EMAIL", session.getUserEmail())
                intent.putExtra("NICKNAME", session.getNickname())
                intent.putExtra("PHONE", session.getPhone())
                startActivity(intent)
            }

        // Privacy Policy
        view.findViewById<LinearLayout>(R.id.menuPrivacyPolicy)
            .setOnClickListener {
                startActivity(Intent(requireContext(),
                    PrivacyPolicyActivity::class.java))
            }

        // Log Out — CLEAR SharedPreferences data
        view.findViewById<LinearLayout>(R.id.menuLogOut)
            .setOnClickListener {
                // Clear all stored session data
                session.clearSession()

                val intent = Intent(requireContext(), OptionActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }

        return view
    }

    // Refresh data when returning from EditProfile
    override fun onResume() {
        super.onResume()
        val session = SessionManager(requireContext())
        view?.findViewById<TextView>(R.id.tvUserName)?.text =
            session.getUserName()
        view?.findViewById<TextView>(R.id.tvUserEmail)?.text =
            session.getUserEmail()
    }
}
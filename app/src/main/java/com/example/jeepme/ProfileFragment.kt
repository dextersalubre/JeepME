package com.example.jeepme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val userName = arguments?.getString("USER_NAME") ?: "User"
        val userEmail = arguments?.getString("USER_EMAIL") ?: "user@email.com"

        view.findViewById<TextView>(R.id.tvUserName).text = userName
        view.findViewById<TextView>(R.id.tvUserEmail).text = userEmail

        // Edit profile
        view.findViewById<LinearLayout>(R.id.menuEditProfile).setOnClickListener {
            val intent = Intent(requireContext(), ProfileEditActivity::class.java)
            intent.putExtra("USER_NAME", userName)
            intent.putExtra("USER_EMAIL", userEmail)
            startActivity(intent)
        }

        // Privacy Policy
        view.findViewById<LinearLayout>(R.id.menuPrivacyPolicy).setOnClickListener {
            startActivity(Intent(requireContext(), PrivacyPolicyActivity::class.java))
        }

        // Log Out
        view.findViewById<LinearLayout>(R.id.menuLogOut).setOnClickListener {
            val intent = Intent(requireContext(), OptionActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return view
    }
}
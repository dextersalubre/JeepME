package profile

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    // Initialize SharedPreferences
    private val prefs: SharedPreferences = context.getSharedPreferences(
        "JeepMePrefs", Context.MODE_PRIVATE
    )

    companion object {
        const val KEY_IS_LOGGED_IN = "is_logged_in"
        const val KEY_USER_NAME = "user_name"
        const val KEY_USER_EMAIL = "user_email"
        const val KEY_NICKNAME = "nickname"
        const val KEY_PHONE = "phone"
    }

    // SAVE login session
    fun saveLoginSession(name: String, email: String) {
        prefs.edit()
            .putBoolean(KEY_IS_LOGGED_IN, true)
            .putString(KEY_USER_NAME, name)
            .putString(KEY_USER_EMAIL, email)
            .apply()
    }

    // RETRIEVE login status
    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    // RETRIEVE user name
    fun getUserName(): String {
        return prefs.getString(KEY_USER_NAME, "User") ?: "User"
    }

    // RETRIEVE user email
    fun getUserEmail(): String {
        return prefs.getString(KEY_USER_EMAIL, "") ?: ""
    }

    // UPDATE profile information
    fun updateProfile(name: String, nickname: String, email: String, phone: String) {
        prefs.edit()
            .putString(KEY_USER_NAME, name)
            .putString(KEY_NICKNAME, nickname)
            .putString(KEY_USER_EMAIL, email)
            .putString(KEY_PHONE, phone)
            .apply()
    }

    // RETRIEVE nickname
    fun getNickname(): String {
        return prefs.getString(KEY_NICKNAME, "") ?: ""
    }

    // RETRIEVE phone
    fun getPhone(): String {
        return prefs.getString(KEY_PHONE, "") ?: ""
    }

    fun clearSession() {

        prefs.edit()
            .remove(KEY_IS_LOGGED_IN)
            .remove(KEY_USER_NAME)
            .remove(KEY_USER_EMAIL)
            .remove(KEY_NICKNAME)
            .remove(KEY_PHONE)
            .apply()
        // NOTE: registered_email and registered_password are NOT cleared
        // so the user can still login after logout
    }

    // SAVE registered email and password during Sign Up
    fun saveRegisteredCredentials(email: String, password: String) {
        prefs.edit()
            .putString("registered_email", email)
            .putString("registered_password", password)
            .apply()
    }

    // GET registered email
    fun getRegisteredEmail(): String {
        return prefs.getString("registered_email", "") ?: ""
    }

    // GET registered password
    fun getRegisteredPassword(): String {
        return prefs.getString("registered_password", "") ?: ""
    }

    // CHECK if entered credentials match saved ones
    fun isValidLogin(email: String, password: String): Boolean {
        val savedEmail = getRegisteredEmail()
        val savedPassword = getRegisteredPassword()
        return email == savedEmail && password == savedPassword
    }
}
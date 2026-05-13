package auth

import profile.SessionManager

class LoginPresenter(
    private val view: LoginContract.View,
    private val session: SessionManager
) : LoginContract.Presenter {

    override fun onLoginClicked(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            view.showEmptyFieldsError()
            return
        }
        if (session.isValidLogin(email, password)) {
            session.saveLoginSession(session.getUserName(), email)
            view.navigateToHome()
        } else {
            view.showError("Invalid email or password. Please register first.")
        }
    }
}
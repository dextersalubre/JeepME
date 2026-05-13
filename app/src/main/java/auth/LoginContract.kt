package auth

interface LoginContract {
    interface View {
        fun showError(message: String)
        fun navigateToHome()
        fun showEmptyFieldsError()
    }
    interface Presenter {
        fun onLoginClicked(email: String, password: String)
    }
}
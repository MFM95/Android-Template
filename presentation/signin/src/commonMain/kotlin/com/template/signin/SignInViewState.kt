package com.template.signin

data class SignInViewState(
    val isLoading: Boolean,
    val isUsernameError: Boolean,
    val isPasswordError: Boolean,
    val errorMessage: String?,
) {
    companion object {
        val Initial = SignInViewState(
            isLoading = false,
            isUsernameError = false,
            isPasswordError = false,
            errorMessage = null
        )
    }
}
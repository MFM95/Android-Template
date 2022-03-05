package com.template.signin

sealed class SignInViewEvent {
    data class SignIn(val userName: String, val password: String) : SignInViewEvent()
}
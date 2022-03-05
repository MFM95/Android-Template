package com.template.signin

sealed class SignInSideEffect {
    object GoToHome : SignInSideEffect()
    object GoToSignUp : SignInSideEffect()
    object GoToForgotPassword : SignInSideEffect()
}
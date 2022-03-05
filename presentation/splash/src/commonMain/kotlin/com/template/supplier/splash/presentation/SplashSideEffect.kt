package com.template.supplier.splash.presentation

sealed class SplashSideEffect {
    object GoToOnBoarding : SplashSideEffect()
    object GoToHome : SplashSideEffect()
}
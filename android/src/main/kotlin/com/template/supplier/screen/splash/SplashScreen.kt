package com.template.supplier.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.template.supplier.base.ComposeViewModel
import com.template.supplier.base.OnSideEffect
import com.template.supplier.navigation.go
import com.template.supplier.screen.splash.navigation.SplashDirections
import com.template.supplier.splash.presentation.SplashSideEffect
import com.template.supplier.splash.presentation.SplashViewEvent
import com.template.supplier.splash.presentation.SplashViewModel

@Composable
fun SplashScreen(navController: NavController) {
    ComposeViewModel<SplashViewModel> { viewModel ->
        LaunchedEffect(true) { viewModel.onEvent(SplashViewEvent.Start) }
        OnSideEffect(viewModel) { effect ->
            val direction = when (effect) {
                is SplashSideEffect.GoToOnBoarding -> SplashDirections.toOnBoarding()
                is SplashSideEffect.GoToHome -> SplashDirections.toHome()
            }
            navController.go(direction)
        }
    }
}

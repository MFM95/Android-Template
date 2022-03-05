package com.template.supplier.splash.presentation.di

import com.template.supplier.splash.presentation.SplashViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

object SplashPresentationDI {
    val module = DI.Module("Splash Presentation Module") {
        bindProvider { SplashViewModel(instance()) }
    }
}
package com.template.supplier.screen.splash.di

import com.template.supplier.splash.presentation.di.SplashPresentationDI
import org.kodein.di.DI

object SplashFeatureDI {
    val module = DI.Module("Splash Feature Module") {
        import(module = SplashPresentationDI.module)
    }

}
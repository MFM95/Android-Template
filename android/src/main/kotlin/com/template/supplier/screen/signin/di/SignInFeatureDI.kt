package com.template.supplier.screen.signin.di


import com.template.signin.di.SignInPresentationDI
import org.kodein.di.DI

object SignInFeatureDI {
    val module = DI.Module("SignIn Feature Module") {
        import(module = SignInPresentationDI.module)
    }
}
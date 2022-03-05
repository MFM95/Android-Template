package com.template.signin.di

import com.template.signin.SignInViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

object SignInPresentationDI {
    val module = DI.Module("SignIn Presentation Module") {
        bindProvider { SignInViewModel(instance(), instance()) }
    }

}
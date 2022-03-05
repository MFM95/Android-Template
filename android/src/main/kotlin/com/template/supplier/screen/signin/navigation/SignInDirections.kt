package com.template.supplier.screen.signin.navigation

import androidx.navigation.navOptions
import com.template.supplier.navigation.MainGraph
import com.template.supplier.navigation.NavDirection


object SignInDirections {

    fun toSignUp(): NavDirection = object : NavDirection {
        override val route = "signUp"
        override val options = navOptions { }
    }

    fun toForgotPassword(): NavDirection = object : NavDirection {
        override val route = "password"
        override val options = navOptions { }
    }

    fun toHome(): NavDirection = object : NavDirection {
        override val route = "home"
        override val options = navOptions { popUpToInclusive(MainGraph.name) }
    }

}
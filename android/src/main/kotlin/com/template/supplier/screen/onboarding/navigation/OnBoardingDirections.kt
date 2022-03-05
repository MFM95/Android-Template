package com.template.supplier.screen.onboarding.navigation

import androidx.navigation.navOptions
import com.template.supplier.navigation.MainGraph

import com.template.supplier.navigation.NavDirection

object OnBoardingDirections {

    fun toSignIn(): NavDirection = object : NavDirection {
        override val route = "signIn"
        override val options = navOptions { popUpToInclusive(MainGraph.name) }
    }

    fun toSignUp(): NavDirection = object : NavDirection {
        override val route = "signUp"
        override val options = navOptions { popUpToInclusive(MainGraph.name) }
    }

}
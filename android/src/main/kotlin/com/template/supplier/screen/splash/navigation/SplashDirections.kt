package com.template.supplier.screen.splash.navigation

import androidx.navigation.navOptions
import com.template.supplier.navigation.MainGraph
import com.template.supplier.navigation.NavDirection
import com.template.supplier.navigation.popUpToInclusive

object SplashDirections {

    fun toOnBoarding(): NavDirection = object : NavDirection {
        override val route = "onBoarding"
        override val options = navOptions { popUpToInclusive(MainGraph.name) }
    }

    fun toHome(): NavDirection = object : NavDirection {
        override val route = "home"
        override val options = navOptions { popUpToInclusive(MainGraph.name) }
    }

}
package com.template.supplier.screen.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.template.supplier.navigation.NavDestination
import com.template.supplier.navigation.destination
import com.template.supplier.screen.splash.SplashScreen


object SplashGraph {
    const val name = "splash"
}

fun NavGraphBuilder.splashGraph(navController: NavController) {
    navigation(
        startDestination = SplashDestination.Root.route,
        route = SplashGraph.name
    ) {
        destination(SplashDestination.Root) { SplashScreen(navController) }
    }
}

sealed class SplashDestination : NavDestination {
    object Root : SplashDestination() {
        override val route: String = "${SplashGraph.name}/root"
    }
}

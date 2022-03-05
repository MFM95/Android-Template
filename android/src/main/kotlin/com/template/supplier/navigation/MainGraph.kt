package com.template.supplier.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.template.supplier.screen.splash.navigation.SplashGraph


object MainGraph {
    const val name = "main"
}

@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashGraph.name,
        route = MainGraph.name
    ) {
        splashGraph(navController)
        onBoardingGraph(navController)
        signInGraph(navController)
    }
}

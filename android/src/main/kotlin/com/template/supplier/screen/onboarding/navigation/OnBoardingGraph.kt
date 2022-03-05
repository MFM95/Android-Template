package com.template.supplier.screen.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.google.accompanist.pager.ExperimentalPagerApi


object OnBoardingGraph {
    const val name = "onBoarding"
}

@ExperimentalPagerApi
fun NavGraphBuilder.onBoardingGraph(navController: NavController) {
    navigation(
        startDestination = OnBoardingDestination.Root.route,
        route = OnBoardingGraph.name
    ) {
        destination(OnBoardingDestination.Root) { OnBoardingScreen(navController) }
    }
}

sealed class OnBoardingDestination : NavDestination {
    object Root : OnBoardingDestination() {
        override val route: String = "${OnBoardingGraph.name}/root"
    }
}
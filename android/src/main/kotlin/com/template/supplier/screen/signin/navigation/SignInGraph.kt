package com.template.supplier.screen.signin.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation


object SignInGraph {
    const val name = "signin"
}


@ExperimentalComposeUiApi
fun NavGraphBuilder.signInGraph(navController: NavController) {
    navigation(
        startDestination = SignInDestination.Root.route,
        route = SignInGraph.name
    ) {
        destination(SignInDestination.Root) { SignInScreen(navController) }
    }
}

sealed class SignInDestination : NavDestination {
    object Root : SignInDestination() {
        override val route: String = "${SignInGraph.name}/root"
    }
}

package com.template.supplier.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.template.supplier.BuildConfig

fun NavGraphBuilder.destination(
    destination: NavDestination,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        destination.route,
        destination.arguments,
        destination.deepLinks,
        content
    )
}

fun NavController.go(direction: NavDirection) {
    navigate(direction.route, direction.options)
}

fun NavOptionsBuilder.popUpToInclusive(route: String) {
    popUpTo(route) { inclusive = true }
}

fun androidx.navigation.NavDestination?.contains(route: String): Boolean =
    this?.hierarchy?.any { it.route == route } == true

@Composable
fun NavController.currentDestination(): androidx.navigation.NavDestination? {
    val backStackEntry by currentBackStackEntryAsState()
    return backStackEntry?.destination
}

@Composable
fun rememberNavController(): NavHostController =
    androidx.navigation.compose.rememberNavController().also {
        if (com.template.supplier.BuildConfig.DEBUG) {
            it.addOnDestinationChangedListener(NavLogger)
        }
    }

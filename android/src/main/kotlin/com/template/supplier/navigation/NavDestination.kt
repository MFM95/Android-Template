package com.template.supplier.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

interface NavDestination {
    val route: String
    val arguments: List<NamedNavArgument> get() = emptyList()
    val deepLinks: List<NavDeepLink> get() = emptyList()
}
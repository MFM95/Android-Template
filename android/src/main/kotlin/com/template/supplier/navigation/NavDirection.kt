package com.template.supplier.navigation

import androidx.navigation.NavOptions
import androidx.navigation.navOptions

interface NavDirection {
    val route: String
    val options: NavOptions get() = navOptions { }
}
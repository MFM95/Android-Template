package com.template.supplier.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

object NavLogger : NavController.OnDestinationChangedListener {
    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        val destinations = destination.hierarchy.map(NavDestination::route).toList().asReversed()
        val msg = "destinations: $destinations, arguments: $arguments"
        Log.d(NavLogger::class.simpleName, msg)
    }
}
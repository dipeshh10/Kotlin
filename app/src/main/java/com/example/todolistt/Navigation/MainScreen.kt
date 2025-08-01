package com.example.todolist.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistt.Pages.HomeScreen
import com.example.todolistt.Pages.StatsScreen
import com.example.todolistt.Pages.ProfileScreen
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(BottomNavItem.Home.route) {
                HomeScreen(navController)
            }
            composable(BottomNavItem.Stats.route) {
                StatsScreen()
            }
            composable(BottomNavItem.Profile.route) {
                ProfileScreen(
                    userName = "Your Name",          // Pass your user state here
                    onUserNameChange = {},           // Provide callback
                    onClearData = {}                 // Provide callback
                )
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    // Basic implementation for a 3-item bottom navigation bar
    NavigationBar {
        val items = listOf(BottomNavItem.Home, BottomNavItem.Stats, BottomNavItem.Profile)
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

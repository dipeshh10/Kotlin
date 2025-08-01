package com.example.todolist.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Stats : BottomNavItem("stats", Icons.Default.Person, "Stats")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}

package com.example.todolistt.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolistt.Pages.HomeScreen
import com.example.todolistt.Pages.LoginScreen
import com.example.todolistt.Pages.SignupScreen
import com.example.todolistt.viewmodel.AuthViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val authViewModel: AuthViewModel = viewModel()
            LoginScreen(navController = navController, viewModel = authViewModel)
        }
        composable("signup") {
            SignupScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
    }
}
package com.example.todolistt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolistt.Pages.CreateTodoScreen
import com.example.todolistt.Pages.LoginScreen
import com.example.todolistt.Pages.SignupScreen
import com.example.todolistt.Pages.WelcomeScreen
import com.example.todolistt.Pages.EditTodoScreen
import com.example.todolistt.Pages.SplashScreen

@Composable
fun TodoAppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("signup") {
            SignupScreen(navController)
        }
        composable("main") {
            // MainScreen()  // Bottom nav with Home, Stats, Profile
        }
        composable("createTodo") {
            CreateTodoScreen(navController)  // Screen to create a new todo item
        }
        composable("editTodo/{todoId}") { backStackEntry ->
            val todoId = backStackEntry.arguments?.getString("todoId")
            EditTodoScreen(navController, todoId)
        }
    }
}

fun LoginScreen(navController: NavHostController) {

}

@Composable
fun EditTodoScreen(navController: NavHostController, todoId: String?) {

}

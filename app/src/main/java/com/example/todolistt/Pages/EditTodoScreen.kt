package com.example.todolistt.Pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Text

@Composable
fun EditTodoScreen(navController: NavController, todoId: String?) {
    Text(text = "Edit Todo Screen. Todo ID: ${todoId ?: "Unknown"}")
}


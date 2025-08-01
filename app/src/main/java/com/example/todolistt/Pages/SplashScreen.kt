package com.example.todolistt.Pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.todolistt.ui.theme.DarkBlue
import com.example.todolistt.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("welcome") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Optional: Replace with your logo
            // Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "Logo")

            Text(
                text = "TodoList",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Stay organized, get things done ✔️",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

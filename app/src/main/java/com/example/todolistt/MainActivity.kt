package com.example.todolistt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.example.todolistt.navigation.NavGraph
import com.example.todolistt.ui.theme.TODOLISTTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOLISTTTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

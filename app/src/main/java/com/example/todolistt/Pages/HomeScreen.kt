package com.example.todolistt.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.todolistt.Pages.TodoCard
import com.example.todolistt.ui.theme.DarkBlue
import com.example.todolistt.ui.theme.LightBlue
import com.example.todolistt.ui.theme.White
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

data class Todo(
    val id: Int,
    val title: String,
    val progress: Int,  // e.g., 0–100 if you want percentage
    val isDone: Boolean
)

@Composable
fun HomeScreen(navController: NavController) {
    val userName = "Prashant"

    val todos = remember {
        listOf(
            Todo(1, "Finish Android Project", 60, false),
            Todo(2, "Buy Groceries", 100, true),
            Todo(3, "Prepare for Meeting", 30, false)
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Hi, $userName 👋 Here’s your Todo List!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue
                )

                Spacer(modifier = Modifier.height(12.dp))

                WeekDaysRow()

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Your Tasks",
                    style = MaterialTheme.typography.titleMedium,
                    color = DarkBlue
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(todos) { todo ->
                        TodoCard(todo = todo)
                    }
                }
            }
            FloatingActionButton(
                onClick = { navController.navigate("createTodo") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd),
                containerColor = DarkBlue,
                contentColor = White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Todo")
            }
        }
    }
}

@Composable
fun WeekDaysRow() {
    val daysOfWeek = DayOfWeek.values()
    val today = LocalDate.now().dayOfWeek

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(daysOfWeek) { day ->
            val isToday = day == today
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (isToday) DarkBlue else Color.LightGray,
                        shape = MaterialTheme.shapes.small
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = day.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                    color = if (isToday) White else Color.Black,
                    fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

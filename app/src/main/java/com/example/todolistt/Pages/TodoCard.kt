package com.example.todolistt.Pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistt.ui.theme.DarkBlue
import com.example.todolistt.ui.theme.White
import com.example.todolistt.ui.theme.LightBlue // Importing shared LightBlue
import com.example.todolistt.Pages.Todo // Import the correct Todo class

val CardBackground = Color(0xFFF2F5FC)

@Composable
fun TodoCard(
    todo: Todo, // Use the correct Todo class
    onEdit: (Todo) -> Unit = {},
    onDelete: (Todo) -> Unit = {},
    onToggleComplete: (Todo) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = todo.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = if (todo.isDone) Color.Gray else DarkBlue
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Progress: ${todo.progress}%",
                    fontSize = 14.sp,
                    color = if (todo.isDone) Color.LightGray else Color.DarkGray
                )
            }

            Checkbox(
                checked = todo.isDone,
                onCheckedChange = { onToggleComplete(todo) },
                colors = CheckboxDefaults.colors(checkedColor = LightBlue)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                IconButton(
                    onClick = { onEdit(todo) },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = LightBlue,
                        modifier = Modifier.size(20.dp)
                    )
                }
                IconButton(
                    onClick = { onDelete(todo) },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
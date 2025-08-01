package com.example.todolistt.Pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistt.ui.theme.DarkBlue
import com.example.todolistt.ui.theme.White

@Composable
fun ProfileScreen(
    userName: String,
    onUserNameChange: (String) -> Unit,
    onClearData: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Profile",
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium,
            color = DarkBlue
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = userName,
            onValueChange = onUserNameChange,
            label = { Text("Your Name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Words),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onClearData,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = DarkBlue)
        ) {
            Text(text = "Clear All Task Data", color = White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "App version: 1.0.0",
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

package com.example.todolistt.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.todolistt.ui.theme.DarkBlue
import com.example.todolistt.ui.theme.LightBlue
import com.example.todolistt.ui.theme.White
import kotlin.math.roundToInt

@Composable
fun StatsScreen() {
    // Mock data - adapt as needed
    val percentDone = 0.75f  // 75%
    val bestStreak = 12
    val completed = 50
    val missed = 8

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Your Stats",
                style = MaterialTheme.typography.headlineMedium,
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(150.dp)
            ) {
                CircularProgressIndicator(
                    progress = percentDone,
                    strokeWidth = 12.dp,
                    color = LightBlue,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "${(percentDone * 100).roundToInt()}%",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatBox(label = "Best Streak", value = "$bestStreak 🏅")
                StatBox(label = "Completed", value = "$completed ✅")
                StatBox(label = "Missed", value = "$missed ❌")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Weekly Progress",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start),
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(12.dp))

            val weekProgress = listOf(0.6f, 0.8f, 0.9f, 0.4f, 1f, 0.7f, 0.5f)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                weekProgress.forEach { progress ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(100.dp)
                            .background(
                                color = LightBlue.copy(alpha = progress),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Top Task",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start),
                color = DarkBlue
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = LightBlue.copy(alpha = 0.1f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Finish Project", fontWeight = FontWeight.Bold)
                    Text(text = "Completed 90% this week")
                }
            }
        }
    }
}

@Composable
fun StatBox(label: String, value: String) {
    Card(
        modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = LightBlue.copy(alpha = 0.1f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = label, fontSize = 14.sp)
        }
    }
}

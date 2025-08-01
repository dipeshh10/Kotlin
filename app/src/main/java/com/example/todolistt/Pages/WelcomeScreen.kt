package com.example.todolistt.Pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import com.example.todolistt.ui.theme.DarkBlue
import com.example.todolistt.ui.theme.LightBlue
import com.example.todolistt.ui.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()

    val pages = listOf(
        "Manage tasks efficiently and stay productive",
        "Stay focused with clean organization",
        "Start now and master your daily goals"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "TodoList",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkBlue
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = pages[page],
                        fontSize = 18.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 20.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                repeat(3) { i ->
                    val isSelected = pagerState.currentPage == i
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(if (isSelected) 12.dp else 8.dp)
                            .background(
                                color = if (isSelected) LightBlue else Color.LightGray,
                                shape = CircleShape
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (pagerState.currentPage < 2) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        navController.navigate("login") {
                            popUpTo("welcome") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkBlue)
            ) {
                Text(
                    text = if (pagerState.currentPage < 2) "Next" else "Get Started",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
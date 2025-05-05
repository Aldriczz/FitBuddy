package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class FitnessExperienceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessExperienceScreen()
        }
    }
}

@Composable
fun FitnessExperienceScreen() {
    val darkBlue = Color(0xFF1D2A5B)
    val lightBlue = Color(0xFFE0F0FF)
    val primaryYellow = Color(0xFFFED28B)

    var selectedOption by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue)
            .padding(24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = "FB",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = primaryYellow
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "FITBUDDY",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Text(
                    text = "Fitness Experience?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(lightBlue, RoundedCornerShape(30.dp))
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Beginner option
                    ExperienceOption(
                        text = "Beginner",
                        isSelected = selectedOption == "Beginner",
                        onClick = { selectedOption = "Beginner" }
                    )

                    // Intermediate option
                    ExperienceOption(
                        text = "Intermediate",
                        isSelected = selectedOption == "Intermediate",
                        onClick = { selectedOption = "Intermediate" }
                    )

                    // Advanced option
                    ExperienceOption(
                        text = "Advanced",
                        isSelected = selectedOption == "Advanced",
                        onClick = { selectedOption = "Advanced" }
                    )
                }

                Button(
                    onClick = { /* Handle continue action */ },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryYellow,
                        contentColor = darkBlue
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    Text("Continue", fontWeight = FontWeight.Bold)
                }
            }
    }
}

@Composable
fun ExperienceOption(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val darkBlue = Color(0xFF1D2A5B)
    val primaryYellow = Color(0xFFFED28B)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = if (isSelected) primaryYellow else Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) darkBlue else Color.Gray,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessExperienceScreenPreview() {
    FitnessExperienceScreen()
}
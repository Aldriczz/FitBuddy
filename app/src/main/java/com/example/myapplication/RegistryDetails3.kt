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

object AppColors {
    val DarkBlue = Color(0xFF1D2A5B)
    val LightBlue = Color(0xFFE0F0FF)
    val PrimaryYellow = Color(0xFFFED28B)
}

// Define dimension constants
object Dimens {
    val OptionCornerRadius = 15.dp
    val ContainerCornerRadius = 30.dp
    val ButtonCornerRadius = 50.dp
    val OptionHeight = 60.dp
    val ButtonHeight = 50.dp
    val HorizontalPadding = 24.dp
    val InnerPadding = 24.dp
    val SpacingLarge = 16.dp
    val SpacingMedium = 12.dp
}

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
    var selectedOption by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.HorizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.SpacingLarge)
        ) {
            // Header with logo and app name
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = Dimens.SpacingLarge, bottom = Dimens.SpacingLarge)
            ) {
                Text(
                    text = "FB",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = AppColors.PrimaryYellow
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "FITBUDDY",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Title
            Text(
                text = "Fitness Experience?",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingLarge))

            // Options container
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColors.LightBlue, RoundedCornerShape(Dimens.ContainerCornerRadius))
                    .padding(Dimens.InnerPadding),
                verticalArrangement = Arrangement.spacedBy(Dimens.SpacingMedium)
            ) {
                ExperienceOption(
                    text = "Beginner",
                    isSelected = selectedOption == "Beginner",
                    onClick = { selectedOption = "Beginner" }
                )

                ExperienceOption(
                    text = "Intermediate",
                    isSelected = selectedOption == "Intermediate",
                    onClick = { selectedOption = "Intermediate" }
                )

                ExperienceOption(
                    text = "Advanced",
                    isSelected = selectedOption == "Advanced",
                    onClick = { selectedOption = "Advanced" }
                )
            }

            // Continue button
            Button(
                onClick = { /* Handle continue action */ },
                shape = RoundedCornerShape(Dimens.ButtonCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.PrimaryYellow,
                    contentColor = AppColors.DarkBlue
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.ButtonHeight)
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

package org.assignment_life_easy.project.UI

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import org.assignment_life_easy.project.OtherDataClasses.VenueStatsCard

@Composable
fun VenueStatsCard(statsCard: VenueStatsCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Venue Stats",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            VenueStatItem("Matches Played", "25")
            VenueStatItem("Lowest Defended", "25")
            VenueStatItem("Highest Chased", "25")
            VenueStatItem("Win Bat First", "25")
            VenueStatItem("Win Ball First", "25")
            VenueStatItem("Highest Chased", "25")

            // Second section - two column layout
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {

                Spacer(modifier = Modifier.weight(1.5f))


                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "1st Inn",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }


                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "2nd Inn",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            VenueStatItemTwoColumn("Avg Score", "320", "120")
            VenueStatItemTwoColumn("Highest Score", "320", "120")
            VenueStatItemTwoColumn("Lowest Score", "320", "120")
            VenueStatItemTwoColumn(
                "Pace Wickets",
                "32 (62%)",
                "22 (41%)",
                firstValueColor = Color(0xFF00FF00),
                secondValueColor = Color(0xFF00FF00)
            )
            VenueStatItemTwoColumn(
                "Spin Score",
                "22 (43%)",
                "32 (62%)",
                firstValueColor = Color(0xFF00FF00),
                secondValueColor = Color(0xFF00FF00)
            )
        }
    }
}

@Composable
private fun VenueStatItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = Color.Gray,
            fontSize = 14.sp
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun VenueStatItemTwoColumn(
    label: String,
    firstValue: String,
    secondValue: String,
    modifier: Modifier = Modifier,
    firstValueColor: Color = Color.White,
    secondValueColor: Color = Color.White
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        // Label column
        Text(
            text = label,
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.weight(1.5f)
        )

        // First innings value
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = firstValue,
                color = firstValueColor,
                fontSize = 14.sp
            )
        }

        // Second innings value
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = secondValue,
                color = secondValueColor,
                fontSize = 14.sp
            )
        }
    }
}
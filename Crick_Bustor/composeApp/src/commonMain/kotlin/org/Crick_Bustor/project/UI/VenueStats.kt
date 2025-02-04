package org.assignment_life_easy.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import org.assignment_life_easy.project.VenueStats


@Composable
fun VenueStats(venueStats: VenueStats) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF1E1E1E))
                .padding(16.dp)
        ) {
            Text(
                text = "Match Statistics",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Matches Played: ${venueStats.matchesPlayed}",
                        color = Color.White
                    )
                    Text(
                        text = "Highest Chased: ${venueStats.highestChased}",
                        color = Color.White
                    )
                    Text(
                        text = "Lowest Defended: ${venueStats.lowestDefended}",
                        color = Color.White
                    )
                }
                Column {
                    Text(
                        text = "Bat First Wins: ${venueStats.batFirstWins}",
                        color = Color.White
                    )
                    Text(
                        text = "Ball First Wins: ${venueStats.ballFirstWins}",
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Batting Stats
            Text(
                text = "Batting Statistics",
                color = Color.White,
                style = MaterialTheme.typography.titleSmall
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "First Innings",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Avg: ${venueStats.battingFirst.averageScore}",
                        color = Color.White
                    )
                    Text(
                        text = "High: ${venueStats.battingFirst.highestScore}",
                        color = Color.White
                    )
                    Text(
                        text = "Low: ${venueStats.battingFirst.lowestScore}",
                        color = Color.White
                    )
                }
                Column {
                    Text(
                        text = "Second Innings",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Avg: ${venueStats.battingSecond.averageScore}",
                        color = Color.White
                    )
                    Text(
                        text = "High: ${venueStats.battingSecond.highestScore}",
                        color = Color.White
                    )
                    Text(
                        text = "Low: ${venueStats.battingSecond.lowestScore}",
                        color = Color.White
                    )
                }
            }
        }
    }
}

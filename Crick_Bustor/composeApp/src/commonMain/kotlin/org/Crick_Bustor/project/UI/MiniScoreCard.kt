package com.example.lifeeasy.UI

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.assignment_life_easy.project.MiniMatchCard


@Composable
fun MiniScoreCard(miniMatchCard: MiniMatchCard) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = androidx.compose.material3.CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF1E1E1E))
                .padding(16.dp)
        ) {
            Text(text = "${miniMatchCard.teamA.name} vs ${miniMatchCard.teamB.name}", color = Color.White, style = MaterialTheme.typography.bodyMedium)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${miniMatchCard.teamA.shortName}: ${miniMatchCard.teamAScore}", color = Color.White)
                Text(text = "${miniMatchCard.teamB.shortName}: ${miniMatchCard.teamBScore}", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Status: ${miniMatchCard.status}", color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

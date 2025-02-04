package org.assignment_life_easy.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun WeatherInfo(weatherInfo: WeatherInfo) {
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
                text = "Location: ${weatherInfo.location}",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Temperature: ${weatherInfo.tempC}°C",
                color = Color.White
            )

            Text(
                text = "Condition: ${weatherInfo.condition.text}",
                color = Color.White
            )

            Text(
                text = "Chance of Rain: ${weatherInfo.chanceOfRain}%",
                color = Color.White
            )

            Text(
                text = "Last Updated: ${weatherInfo.lastUpdated}",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}



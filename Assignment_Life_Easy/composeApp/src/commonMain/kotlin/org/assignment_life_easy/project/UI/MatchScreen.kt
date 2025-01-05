package com.example.lifeeasy.UI

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import org.assignment_life_easy.project.MatchViewModel
import org.assignment_life_easy.project.VenueInfo
import org.assignment_life_easy.project.VenueStats
import org.assignment_life_easy.project.WeatherInfo
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun MatchScreen(viewModel: MatchViewModel) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        // Show loading spinner while data is being fetched
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            // Show error message if data failed to load
            state.error?.let {
                Text(text = it, color = Color.Red, modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            // Display the data
            state.miniScoreCard?.let { miniMatchCard ->
                MiniScoreCard(miniMatchCard = miniMatchCard)
            }

            state.venueInfo?.let { venueInfo ->
                VenueInfo(venueInfo = venueInfo)
            }

            state.venueInfo?.venueStats?.let { venueStats ->
                VenueStats(venueStats = venueStats)
            }

            state.venueInfo?.weather?.let { weatherInfo ->
                WeatherInfo(weatherInfo = weatherInfo)
            }
        }
    }
}

//@Preview()
//@Composable
//fun CricketScoreScreenPreview() {
//    MatchScreen(viewModel = viewModel()) // Preview the screen
//}


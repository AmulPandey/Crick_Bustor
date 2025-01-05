package org.assignment_life_easy.project

import androidx.compose.runtime.*
import com.example.lifeeasy.UI.MatchScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(apiClient: MatchRepository) {
    val viewModel = remember { MatchViewModel(apiClient) } // Initialize ViewModel with the repository
    MatchScreen(viewModel = viewModel) // Pass ViewModel to the MatchScreen
}

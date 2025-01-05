package org.assignment_life_easy.project

import androidx.compose.runtime.*
import org.assignment_life_easy.project.UI.MatchScreen
import org.assignment_life_easy.project.ViewModel.MatchViewModel
import org.assignment_life_easy.project.di.initKoin

import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin

@Composable
@Preview
fun App(apiClient: ApiClient) {

    initKoin {
    }

    val viewModel = remember { MatchViewModel(apiClient) }
    MatchScreen(viewModel = viewModel)
}


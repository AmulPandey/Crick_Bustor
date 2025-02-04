package org.Crick_Bustor.project

import androidx.compose.runtime.*

import org.Crick_Bustor.project.UI.MatchScreen
import org.Crick_Bustor.project.di.initKoin
import org.Crick_Bustor.project.ViewModel.MatchViewModel


import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(apiClient: ApiClient) {

    initKoin {
    }

    val viewModel = remember { MatchViewModel(apiClient) }
    MatchScreen(viewModel = viewModel)
}


package org.assignment_life_easy.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.falcon.news.data.network.createHttpClient

fun MainViewController() = ComposeUIViewController { App(remember{ MatchRepository(createHttpClient(io.ktor.client.engine.okhttp.OkHttp.create())) }) }
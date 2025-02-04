package org.assignment_life_easy.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.falcon.news.data.network.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(remember{MatchRepository(createHttpClient(OkHttp.create()))})
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(remember{ MatchRepository(createHttpClient(OkHttp.create())) })
}
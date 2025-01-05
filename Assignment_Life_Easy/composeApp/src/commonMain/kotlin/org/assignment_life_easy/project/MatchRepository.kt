package org.assignment_life_easy.project

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class MatchRepository(private val client: HttpClient) {

    companion object {
        private const val BASE_URL = "http://3.6.243.12:5001"
        private const val AUTHORIZATION_HEADER = "Basic Y3JpY2tldFJhZGlvOmNyaWNrZXRAJCUjUmFkaW8xMjM="
        private const val API_KEY = "SA_vs_SL_2024-12-05_1732276435.300452"
    }

    // API Call for Mini Scorecard
    suspend fun getMiniScoreCard(): Result<MiniMatchCard> = withContext(Dispatchers.IO) {
        try {
            val response: MiniMatchCard = client.get("$BASE_URL/api/v2/match/mini-match-card") {
                method = HttpMethod.Get // Explicitly specify the method
                header(HttpHeaders.Authorization, AUTHORIZATION_HEADER)
                url {
                    parameters.append("key", API_KEY)
                }
            }.body()

            Result.success(response)
        } catch (e: Exception) {
            println("MiniScoreCard Error: ${e.message}")
            Result.failure(e)
        }
    }

    // API Call for Venue Info
    suspend fun getVenueInfo(): Result<VenueInfo> = withContext(Dispatchers.IO) {
        try {
            val response: VenueInfo = client.get("$BASE_URL/api/v2/match/venue-info") {
                method = HttpMethod.Get // Explicitly specify the method
                header(HttpHeaders.Authorization, AUTHORIZATION_HEADER)
                url {
                    parameters.append("key", API_KEY)
                }
            }.body()

            Result.success(response)
        } catch (e: Exception) {
            println("VenueInfo Error: ${e.message}")
            Result.failure(e)
        }
    }
}

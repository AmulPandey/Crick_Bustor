@file:OptIn(InternalAPI::class, InternalAPI::class)

package org.assignment_life_easy.project

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.HttpMethod
import io.ktor.util.InternalAPI
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.assignment_life_easy.project.DataClasses.MiniMatchCard
import org.assignment_life_easy.project.OtherDataClasses.VenueStatsCard

class ApiClient(
    private val httpClient: HttpClient
) {
    private val baseUrl = "http://3.6.243.12:5001" // TODO: Change this URL
    private val AUTHORIZATION_HEADER = "Basic Y3JpY2tldFJhZGlvOmNyaWNrZXRAJCUjUmFkaW8xMjM="
    private val API_KEY = "SA_vs_SL_2024-12-05_1732276435.300452"


    private suspend inline fun <reified T> makeApiCall(
        url: String,
        method: HttpMethod = HttpMethod.Get,  // Default to GET method
        params: Map<String, String>? = null,
        body: Any? = null, // To be used for POST requests
        headers: Map<String, String>? = null
    ): Result<T, NetworkError> {
        val response = try {
            when (method) {
                HttpMethod.Get -> {
                    httpClient.get(urlString = url) {
                        params?.forEach { (key, value) ->
                            parameter(key, value)
                        }
                        headers?.forEach { (key, value) ->
                            header(key, value)
                        }
                    }
                }
                HttpMethod.Post -> {
                    httpClient.post(urlString = url) {
                        params?.forEach { (key, value) ->
                            parameter(key, value)
                        }
                        body?.let { setBody(it) }
                        headers?.forEach { (key, value) ->
                            header(key, value)
                        }
                    }
                }
                HttpMethod.Put -> {
                    httpClient.put(urlString = url) {
                        params?.forEach { (key, value) ->
                            parameter(key, value)
                        }
                        body?.let { setBody(it) }
                        headers?.forEach { (key, value) ->
                            header(key, value)
                        }
                    }
                }
                HttpMethod.Delete -> {
                    httpClient.delete(urlString = url) {
                        params?.forEach { (key, value) ->
                            parameter(key, value)
                        }
                        headers?.forEach { (key, value) ->
                            header(key, value)
                        }
                    }
                }
                else -> throw IllegalArgumentException("Unsupported HTTP method")
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }


        println("Raw response body: ${response.content.readRemaining().readText()}")

        return when (response.status.value) {
            in 200..299 -> {
                try {
                    val responseBody: T = response.body()
                    Result.Success(responseBody)
                } catch (e: Exception) {
                    println("Error deserializing response: ${e.message}")
                    Result.Error(NetworkError.SERIALIZATION)
                }
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            403 -> Result.Error(NetworkError.FORBIDDEN)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> {
                println("Unexpected response: ${response.content.readRemaining().readText()}")
                Result.Error(NetworkError.UNKNOWN)
            }
        }
    }


    suspend fun getMiniScoreCard(): Result<MiniMatchCard, NetworkError> {
        val url = "${baseUrl}/api/v2/match/mini-match-card"
        val params = mapOf("key" to API_KEY)
        val headers = mapOf("Authorization" to AUTHORIZATION_HEADER)

        return makeApiCall(url = url, method = HttpMethod.Get, params = params, headers = headers)
    }

    suspend fun getVenueStatusCard(): Result<VenueStatsCard, NetworkError> {
        val url = "${baseUrl}/api/v2/match/venue-info"
        val params = mapOf("key" to API_KEY)
        val headers = mapOf("Authorization" to AUTHORIZATION_HEADER)

        return makeApiCall(url = url, method = HttpMethod.Get, params = params, headers = headers)
    }
}

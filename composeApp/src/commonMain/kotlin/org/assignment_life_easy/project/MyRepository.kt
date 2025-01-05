package org.assignment_life_easy.project


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.assignment_life_easy.project.DataClasses.MiniMatchCard
import org.assignment_life_easy.project.OtherDataClasses.VenueStatsCard

class MyRepository(private val apiClient: ApiClient) {


    suspend fun getMiniScoreCard(): Result<MiniMatchCard, NetworkError> {
        return withContext(Dispatchers.IO) {
            apiClient.getMiniScoreCard()
        }
    }


    suspend fun getVenueStatusCard(): Result<VenueStatsCard, NetworkError> {
        return withContext(Dispatchers.IO) {
            apiClient.getVenueStatusCard()
        }
    }
}

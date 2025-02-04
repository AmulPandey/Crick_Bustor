package org.Crick_Bustor.project


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.Crick_Bustor.project.DataClasses.MiniMatchCard
import org.Crick_Bustor.project.OtherDataClasses.VenueStatsCard


import org.assignment_life_easy.project.Result

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

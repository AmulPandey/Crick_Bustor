package org.Crick_Bustor.project.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.Crick_Bustor.project.ApiClient
import org.Crick_Bustor.project.DataClasses.MiniMatchCard
import org.Crick_Bustor.project.OtherDataClasses.VenueStatsCard


class MatchViewModel(
    private val apiClient: ApiClient
) : ViewModel() {



    private val _state = MutableStateFlow<MatchState>(MatchState.Loading)
    val state: StateFlow<MatchState> = _state


    private val _venueState = MutableStateFlow<VenueState>(VenueState.Loading)
    val venueState: StateFlow<VenueState> = _venueState


    init {
        loadMatchData()
    }

    private fun loadMatchData() {
        viewModelScope.launch {

            when (val miniScoreResult = apiClient.getMiniScoreCard()) {
                is org.assignment_life_easy.project.Result.Error -> {

                    _state.value = MatchState.Error(miniScoreResult.error.name)
                }
                is org.assignment_life_easy.project.Result.Success -> {

                    _state.value = MatchState.Success(miniScoreResult.data)
                }
            }


            when (val venueInfoResult = apiClient.getVenueStatusCard()) {
                is org.assignment_life_easy.project.Result.Error -> {

                    _venueState.value = VenueState.Error(venueInfoResult.error.name)
                }
                is org.assignment_life_easy.project.Result.Success -> {

                    val venueStatsCard = venueInfoResult.data as? VenueStatsCard
                    if (venueStatsCard != null) {
                        _venueState.value = VenueState.Success(venueStatsCard)
                    } else {
                        _venueState.value =
                            VenueState.Error("Invalid data format for VenueStatsCard")
                    }
                }
            }


        }
    }
}


sealed class MatchState {
    object Loading : MatchState()
    data class Success(val data: MiniMatchCard) : MatchState()
    data class Error(val error: String) : MatchState()
}


sealed class VenueState {
    object Loading : VenueState()
    data class Success(val data: VenueStatsCard) : VenueState()
    data class Error(val error: String) : VenueState()
}

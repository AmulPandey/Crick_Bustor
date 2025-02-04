package org.assignment_life_easy.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MatchViewModel(
    private val repository: MatchRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(MatchState(isLoading = true))
    val state: StateFlow<MatchState> = _state

    init {
        loadMatchData()
    }

    private fun loadMatchData() {
        viewModelScope.launch {
            try {
                val matchId = "SAvsSL202412051732276435.300452"

                // Fetch data from repository
                val miniScoreResult = repository.getMiniScoreCard()
                val venueInfoResult = repository.getVenueInfo()

                // If API responses are successful, update the state
                if (miniScoreResult.isSuccess && venueInfoResult.isSuccess) {
                    val miniScoreCard = miniScoreResult.getOrNull()
                    val venueInfo = venueInfoResult.getOrNull()

                    _state.value = MatchState(
                        miniScoreCard = miniScoreCard,
                        venueInfo = venueInfo,
                        isLoading = false
                    )
                } else {
                    _state.value = MatchState(
                        isLoading = false,
                        error = "Failed to load data"
                    )
                }
            } catch (e: Exception) {
                _state.value = MatchState(
                    isLoading = false,
                    error = "Unexpected error occurred"
                )
                e.printStackTrace()
            }
        }
    }
}

package org.assignment_life_easy.project

import kotlinx.serialization.Serializable

@Serializable
data class MiniMatchCard(
    val teamA: TeamDetails,
    val teamAScore: String? = null,
    val status: String,
    val teamB: TeamDetails,
    val teamBScore: String? = null
)

@Serializable
data class TeamDetails(
    val name: String,
    val shortName: String,
    val logo: String
)

@Serializable
data class VenueInfo(
    val venueName: String,
    val matchDetails: String,
    val weather: WeatherInfo,
    val venueStats: VenueStats
)

@Serializable
data class WeatherInfo(
    val location: String,
    val condition: WeatherCondition,
    val chanceOfRain: Int,
    val tempC: Double,
    val lastUpdated: String,
    val iconUrl: String,  // URL for the weather icon
)

@Serializable
data class WeatherCondition(
    val code: Int,
    val icon: String,
    val text: String


)

@Serializable
data class VenueStats(
    val matchesPlayed: Int,
    val lowestDefended: Int,
    val highestChased: Int,
    val batFirstWins: Int,
    val ballFirstWins: Int,
    val battingFirst: BattingStats,
    val battingSecond: BattingStats
)

@Serializable
data class BattingStats(
    val averageScore: Int,
    val highestScore: Int,
    val lowestScore: Int,
    val paceWickets: Int,
    val spinWickets: Int
)

@Serializable
data class MatchState(
    val miniScoreCard: MiniMatchCard? = null,
    val venueInfo: VenueInfo? = null,
    val matchReferee: String? = null,
    val toss: TossInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@Serializable
data class TossInfo(
    val won: String,
    val decision: String,
    val str: String
)



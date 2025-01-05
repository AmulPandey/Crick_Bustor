package org.assignment_life_easy.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class VenueStats(
    val ballFirstWins: Int,
    val batFirstWins: Int,
    val battingFirst: BattingFirst,
    val battingSecond: BattingSecond,
    val highestChased: Int,
    val lowestDefended: Int,
    val matchesPlayed: Int
)
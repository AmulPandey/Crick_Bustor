package org.Crick_Bustor.project.OtherDataClasses

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
package org.assignment_life_easy.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class BattingFirst(
    val averageScore: Int,
    val highestScore: Int,
    val lowestScore: Int,
    val paceWickets: Int,
    val spinWickets: Int
)
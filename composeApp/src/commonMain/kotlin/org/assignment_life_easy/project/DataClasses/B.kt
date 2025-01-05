package org.assignment_life_easy.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class B(
    val b_1_score: B1Score,
    val b_2_score: B1Score,
    val logo: String,
    val name: String,
    val shortName: String
)
package org.assignment_life_easy.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class B1Score(
    val declare: Boolean,
    val overs: String,
    val runs: Int,
    val wickets: Int
)
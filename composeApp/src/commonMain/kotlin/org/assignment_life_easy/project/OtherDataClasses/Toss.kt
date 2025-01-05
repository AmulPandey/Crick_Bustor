package org.assignment_life_easy.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Toss(
    val decision: String,
    val str: String,
    val won: String
)
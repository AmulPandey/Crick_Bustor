package org.assignment_life_easy.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class StartDate(
    val iso: String,
    val sky_check_ts: Int,
    val str: String,
    val timestamp: Int
)
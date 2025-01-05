package org.assignment_life_easy.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class SettingObj(
    val currentInning: Int,
    val currentTeam: String
)
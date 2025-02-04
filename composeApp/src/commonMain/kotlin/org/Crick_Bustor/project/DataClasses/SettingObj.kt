package org.Crick_Bustor.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class SettingObj(
    val currentInning: Int,
    val currentTeam: String
)
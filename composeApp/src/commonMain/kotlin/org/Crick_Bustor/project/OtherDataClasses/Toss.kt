package org.Crick_Bustor.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Toss(
    val decision: String,
    val str: String,
    val won: String
)
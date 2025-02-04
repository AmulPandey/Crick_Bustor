package org.Crick_Bustor.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)
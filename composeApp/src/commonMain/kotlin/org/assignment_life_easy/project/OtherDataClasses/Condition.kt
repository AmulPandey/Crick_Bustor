package org.assignment_life_easy.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)
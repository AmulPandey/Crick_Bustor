package org.Crick_Bustor.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Commentary(
    val primaryText: String,
    val secondaryText: String? = null,
    val tertiaryText: String? = null,
    val isDone: Boolean
)
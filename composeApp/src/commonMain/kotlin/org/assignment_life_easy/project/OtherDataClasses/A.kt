package org.assignment_life_easy.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class A(
    val logo: String,
    val name: String,
    val shortName: String
)
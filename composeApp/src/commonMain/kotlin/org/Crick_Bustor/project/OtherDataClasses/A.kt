package org.Crick_Bustor.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class A(
    val logo: String,
    val name: String,
    val shortName: String
)
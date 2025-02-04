package org.Crick_Bustor.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class A(
    val name: String,
    val shortName: String,
    val logo: String,
    val a_1_score: A1Score?= null,
    val a_2_score: A1Score? = null,
    val b_1_score: B1Score? = null,
    val b_2_score: B1Score? = null
)

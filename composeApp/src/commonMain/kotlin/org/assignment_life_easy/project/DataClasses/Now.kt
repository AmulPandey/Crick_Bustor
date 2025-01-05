package org.assignment_life_easy.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Now(
    val req_run_rate: String,
    val run_rate: String,
    val sessionLeft: String?
)
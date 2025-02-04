package org.Crick_Bustor.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Now(
    val req_run_rate: String,
    val run_rate: String,
    val sessionLeft: String?
)
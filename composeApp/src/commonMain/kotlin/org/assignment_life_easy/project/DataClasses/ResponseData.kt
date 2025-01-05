package org.assignment_life_easy.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val message: String,
    val result: Result
)
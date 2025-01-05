package org.assignment_life_easy.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val message: String?,
    val result: Result
)
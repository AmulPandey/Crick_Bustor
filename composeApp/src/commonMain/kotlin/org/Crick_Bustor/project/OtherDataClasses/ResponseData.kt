package org.Crick_Bustor.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val message: String?,
    val result: Result
)
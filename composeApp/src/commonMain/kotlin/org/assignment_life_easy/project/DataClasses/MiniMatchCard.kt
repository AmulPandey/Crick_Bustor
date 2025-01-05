package org.assignment_life_easy.project.DataClasses

import kotlinx.serialization.Serializable


@Serializable
data class MiniMatchCard(
    val requestParams: Map<String, String> = emptyMap(),
    val responseData: ResponseData? = null,
    val statusCode: Int = 0,
    val time: String = ""
)



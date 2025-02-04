package org.Crick_Bustor.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class VenueStatsCard(
    val requestParams: RequestParams,
    val responseData: ResponseData,
    val statusCode: Int,
    val time: String
)
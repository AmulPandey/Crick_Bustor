package org.Crick_Bustor.project.OtherDataClasses

import kotlinx.serialization.Serializable

@Serializable
data class VenueInfoX(
    val location: String?,
    val longName: String?,
    val name: String?,
    val smallName: String?,
    val town: String?
)
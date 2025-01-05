package org.assignment_life_easy.project.DataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val powerplay: String,
    val powerplayOver: Int,
    val key: String,
    val status: String,
    val format: String,
    val announcement1: String,
    val teams: Teams,
    val now: Now,
    val currentBattingOrder: Int,
    val settingObj: SettingObj,
    val lastCommentary: Commentary,
    val announcement2: String? = null
)

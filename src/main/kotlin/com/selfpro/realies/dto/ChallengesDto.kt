package com.selfpro.realies.dto

data class ChallengesDto(
    val author: String,
    val title: String? = null,
    val image: List<String>? = null,
    val content: String,
    val publishedAt: String,
    val challengeRank: Int = 5
)
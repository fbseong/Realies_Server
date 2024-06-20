package com.selfpro.realies.dto

data class ChallengesDto(
    override val title: String,
    override val content: String,
    override val publishedAt: String,
    val author: String,
    val image: List<String>? = null,
    val challengeRank: Int = 5
): NewsDto{

}
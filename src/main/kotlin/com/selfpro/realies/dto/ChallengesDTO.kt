package com.selfpro.realies.dto

data class ChallengesDTO(
    override val title: String,
    override val content: String,
    override val images: List<String>?,

    val author: String,
) : NewsDTO {

}
package com.selfpro.realies.request

data class ChallengesDTO(
    override val title: String,
    override val content: String,
    override val images: List<String>?,

    val author: String,
) : NewsDTO {

}
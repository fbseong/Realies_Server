package com.selfpro.realies.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "challenges")
open class Challenges(
    override val title: String,
    override val content: String,
    override val publishedAt: String,
    val author: String,
    val image: List<String>? = null,
    val challengeRank: Int = 5,
):News{

}
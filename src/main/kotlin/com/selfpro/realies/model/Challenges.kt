package com.selfpro.realies.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "challenges")
data class Challenges(
    val author: String,
    val title: String? = null,
    val image: List<String>? = null,
    val content: String,
    val publishedAt: String,
    val challengeRank: Int = 5
)
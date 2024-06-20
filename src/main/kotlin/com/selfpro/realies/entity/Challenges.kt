package com.selfpro.realies.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "challenges")
open class Challenges(
    override val title: String,
    override val content: String,
    override val publishedAt: String,
    override val images: List<String>?,

    val author: String,
    val challengeRank: Int = 5,
) : News {}
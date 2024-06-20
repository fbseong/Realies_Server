package com.selfpro.realies.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "realies")
data class Realies(
    val title: String,
    val author: String?,
    val image: String? = null,
    val url: String? = null,
    val content: String?,
    val createdAt: String? = null
)

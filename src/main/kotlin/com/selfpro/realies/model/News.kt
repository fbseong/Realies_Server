package com.selfpro.realies.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collation = "news")
data class News(
    val title: String,
    val author: String?,
    val image: String? = null,
    val url: String? = null,
    val content: String?,
    val createdAt: String? = null
)

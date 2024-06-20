package com.selfpro.realies.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "realies")
data class Realies(
    override val title: String,
    override val content: String,
    override val publishedAt: String,
    val provider: String? = null,
    val image: String? = null,
    val url: String? = null,
):News{

}

package com.selfpro.realies.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "realies")
data class Realies(
    override val title: String,
    override val content: String,
    override val publishedAt: String,
    override val images: List<String>?,

    val provider: String? = null,
    val url: String? = null,
):News{

}

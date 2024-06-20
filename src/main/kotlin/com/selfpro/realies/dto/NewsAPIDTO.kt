package com.selfpro.realies.dto

data class NewsAPIDTO(
    val status: String,
    val totalResults: Int,
    val articles: List<RealiesArticle>
) {
    data class RealiesArticle(
        val source: Source,
        val author: String?,
        val title: String,
        val description: String?,
        val url: String,
        val urlToImage: String?,
        val publishedAt: String,
        val content: String?
    )

    data class Source(
        val id: String?,
        val name: String
    )
}
package com.selfpro.realies.dto

data class NewsAPIDto(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsArticle>
) {
    data class NewsArticle(
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
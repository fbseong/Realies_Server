package com.selfpro.realies.dto

data class NewsDto(
    val author: String,
    val title: String,
    val image: String? = null,
    val url: String? = null,
    val content: String,
)
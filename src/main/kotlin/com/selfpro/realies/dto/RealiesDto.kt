package com.selfpro.realies.dto

import com.selfpro.realies.model.News

data class RealiesDto(
    override val title: String,
    override val content: String,
    override val publishedAt: String,
    val provider: String? = null,
    val image: String? = null,
    val url: String? = null,
) : NewsDto {

}
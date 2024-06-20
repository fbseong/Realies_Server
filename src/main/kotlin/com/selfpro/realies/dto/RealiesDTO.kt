package com.selfpro.realies.dto

data class RealiesDTO(
    override val title: String,
    override val content: String,
    override val images: List<String>?,
    val provider: String? = null,
    val url: String? = null,
) : NewsDTO {

}
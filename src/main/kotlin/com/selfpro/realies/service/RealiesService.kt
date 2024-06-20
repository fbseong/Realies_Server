package com.selfpro.realies.service

import com.selfpro.realies.dto.RealiesAPIDto
import com.selfpro.realies.model.Realies
import reactor.core.publisher.Mono

interface RealiesService {
    fun createNews(realies: Realies): Realies
    fun getAllNews(): List<Realies>
    fun getNewsById(id: String?): Realies?
    fun deleteNewsById(id: String?)
    fun getRecommendationNewsFromNewsAPI(): Mono<List<RealiesAPIDto.RealiesArticle>>
}
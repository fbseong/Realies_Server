package com.selfpro.realies.service

import com.selfpro.realies.entity.Realies
import reactor.core.publisher.Mono

interface RealiesService {
    fun createNews(realies: Realies): Realies
    fun getAllNews(): List<Realies>
    fun getNewsById(id: String?): Realies?
    fun deleteNewsById(id: String?)
    fun getRecommendationNewsFromNewsAPI(page: Int?): Mono<List<Realies>>
}
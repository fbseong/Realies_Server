package com.selfpro.realies.service

import com.selfpro.realies.model.News
import com.selfpro.realies.dto.NewsAPIDto.NewsArticle
import reactor.core.publisher.Mono

interface NewsService {
    fun createNews(news: News): News
    fun getAllNews(): List<News>
    fun getNewsById(id: String?): News?
    fun deleteNewsById(id: String?)
    fun getRecommendationNewsFromNewsAPI(): Mono<List<NewsArticle>>
}
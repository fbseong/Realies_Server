package com.selfpro.realies.service.impl

import com.selfpro.realies.dto.NewsAPIDto
import com.selfpro.realies.model.News
import com.selfpro.realies.repository.NewsRepository
import com.selfpro.realies.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class NewsServiceImpl @Autowired constructor(
    private val newsRepository: NewsRepository,
    private val webClient: WebClient
) : NewsService {
    override fun createNews(news: News): News {
        return news.let { newsRepository.save(it) }
    }

    override fun getAllNews(): List<News> {
        return listOf()//newsRepository.findAll()
    }

    override fun getNewsById(id: String?): News? {
        return id?.let { newsRepository.findById(it).orElse(null) }
    }

    override fun deleteNewsById(id: String?) {
        if (id != null) {
            newsRepository.deleteById(id)
        }
    }

    override fun getRecommendationNewsFromNewsAPI(): Mono<List<NewsAPIDto.NewsArticle>> {
        return webClient.get()
            .uri{uriBuilder->
                uriBuilder
                    .path("/v2/top-headlines")
                    .queryParam("country","kr")
                    .queryParam("sortBy","popularity")
                    .queryParam("apiKey","91bf7199ef0e40e0a79cf3dcf70b4dbf")
                    .build()
            }
            .retrieve()
            .bodyToMono(NewsAPIDto::class.java)
            .map { it.articles }
    }

}
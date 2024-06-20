package com.selfpro.realies.service.impl

import com.selfpro.realies.dto.NewsAPIDTO
import com.selfpro.realies.entity.Realies
import com.selfpro.realies.repository.RealiesRepository
import com.selfpro.realies.service.RealiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RealiesServiceImpl @Autowired constructor(
    private val realiesRepository: RealiesRepository,
    private val webClient: WebClient
) : RealiesService {
    override fun createNews(realies: Realies): Realies {
        return realies.let { realiesRepository.save(it) }
    }

    override fun getAllNews(): List<Realies> {
        return listOf()//newsRepository.findAll()
    }

    override fun getNewsById(id: String?): Realies? {
        return id?.let { realiesRepository.findById(it).orElse(null) }
    }

    override fun deleteNewsById(id: String?) {
        if (id != null) {
            realiesRepository.deleteById(id)
        }
    }

    override fun getRecommendationNewsFromNewsAPI(page: Int?): Mono<List<Realies>> {
        if (page != null) {
            return webClient.get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/v2/top-headlines")
                        .queryParam("country", "kr")
                        .queryParam("pageSize", 20)
                        .queryParam("page", page)
                        .queryParam("apiKey", "91bf7199ef0e40e0a79cf3dcf70b4dbf")
                        .build()
                }
                .retrieve()
                .bodyToMono(NewsAPIDTO::class.java)
                .map { it.articles }
                .flatMap { list ->
                    Flux
                        .fromIterable(list)
                        .map {
                            Realies(
                                title = it.title,
                                content = it.description ?: "",
                                publishedAt = it.publishedAt,
                                images = it.urlToImage?.let { listOf(it) },
                                provider = it.source.name,
                                url = it.url
                            )
                        }
                        .collectList()
                }
        } else return Mono.just(emptyList())
    }

}
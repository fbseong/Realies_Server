package com.selfpro.realies.controller

import com.selfpro.realies.dto.NewsAPIDto
import com.selfpro.realies.dto.NewsDto
import com.selfpro.realies.model.News
import com.selfpro.realies.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/news")
class NewsController @Autowired constructor(private val newsService: NewsService) {

    @PostMapping
    fun createUser(@RequestBody newsDto: NewsDto): News? {
        return newsService.createNews(
            newsDto.run {
                News(
                    author = author,
                    title = title,
                    content = content
                )
            }
        )
    }

    @GetMapping
    fun getAllUsers(): List<News> {
        return newsService.getAllNews()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String?): News? {
        return newsService.getNewsById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: String?) {
        newsService.deleteNewsById(id)
    }

    @GetMapping("/recommendation")
    fun getExternalNews(): Mono<List<NewsDto>> {
        return newsService.getRecommendationNewsFromNewsAPI().flatMap { list ->
            Flux.fromIterable(list)
                .map {
                    NewsDto(
                        author = it.author,
                        title = it.title,
                        image = it.urlToImage,
                        url = it.url,
                        broadCaster = it.source.name,
                        publishedAt = it.publishedAt,
                        content = it.description
                    )
                }
                .collectList()
        }
    }


}
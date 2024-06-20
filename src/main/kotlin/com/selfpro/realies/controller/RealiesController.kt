package com.selfpro.realies.controller

import com.selfpro.realies.dto.RealiesDto
import com.selfpro.realies.model.Realies
import com.selfpro.realies.service.RealiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/news")
class RealiesController @Autowired constructor(private val realiesService: RealiesService) {

    @PostMapping
    fun createUser(@RequestBody realiesDto: RealiesDto): Realies? {
        return realiesService.createNews(
            realiesDto.run {
                Realies(
                    author = author,
                    title = title,
                    content = content
                )
            }
        )
    }

    @GetMapping
    fun getAllUsers(): List<Realies> {
        return realiesService.getAllNews()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String?): Realies? {
        return realiesService.getNewsById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: String?) {
        realiesService.deleteNewsById(id)
    }

    @GetMapping("/recommendation")
    fun getExternalNews(): Mono<List<RealiesDto>> {
        return realiesService.getRecommendationNewsFromNewsAPI().flatMap { list ->
            Flux.fromIterable(list).map {
                    RealiesDto(
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
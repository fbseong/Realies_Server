package com.selfpro.realies.controller

import com.selfpro.realies.dto.ChallengesDto
import com.selfpro.realies.dto.NewsDto
import com.selfpro.realies.dto.RealiesDto
import com.selfpro.realies.model.Challenges
import com.selfpro.realies.model.News
import com.selfpro.realies.model.Realies
import com.selfpro.realies.service.ChallengesService
import com.selfpro.realies.service.RealiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/news")
class RealiesController @Autowired constructor(
    private val realiesService: RealiesService,
    private val challengesService: ChallengesService
) {

    @GetMapping("/recommendation/{page}")
    fun getRecommendationRealies(@PathVariable page: Int?): Mono<List<NewsDto>> {
        if (page != null) {
            //News from NewsAPI
            val apiNewsMono = realiesService.getRecommendationNewsFromNewsAPI(page+1).flatMap { list ->
                Flux.fromIterable(list)
                    .map {
                        RealiesDto(
                            title = it.title,
                            content = it.description ?: "",
                            publishedAt = it.publishedAt,
                            provider = it.source.name,
                            image = null,
                            url = it.url
                        )
                    }
                    .collectList()
            }
            //ChallengesNews from Challenges DB
            val challengesMono = Mono.fromCallable { challengesService.getRecommendationRealies(page) }
                .flatMapMany { Flux.fromIterable(it) }
                .map {
                    ChallengesDto(
                        author = it.author,
                        title = it.title,
                        image = it.image,
                        content = it.content,
                        publishedAt = it.publishedAt,
                        challengeRank = it.challengeRank
                    )
                }
                .collectList()

            //Combine apiNewMono with challengesMono
            return apiNewsMono.zipWith(challengesMono) { list1, list2 ->
                (list1 + list2).sortedBy { LocalDateTime.parse(it.publishedAt, DateTimeFormatter.ISO_DATE_TIME) }
            }
        } else return Mono.just(emptyList())

    }

}
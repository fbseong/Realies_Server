package com.selfpro.realies.controller

import com.selfpro.realies.entity.News
import com.selfpro.realies.service.ChallengesService
import com.selfpro.realies.service.RealiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/news")
class RealiesController @Autowired constructor(
    private val realiesService: RealiesService,
    private val challengesService: ChallengesService
) {
    @GetMapping("/recommendation")
    fun getRecommendationRealies(@RequestParam page: Int?): Mono<List<News>> {
        if (page != null) {
            //News from NewsAPI
            val apiNewsMono = realiesService.getRecommendationNewsFromNewsAPI(page + 1)

            //ChallengesNews from Challenges DB
            val challengesListMono = challengesService.getRecommendationRealies(page)

            //Combine apiNewMono with challengesMono and Sort by publishedAt
            return apiNewsMono.zipWith(challengesListMono) { apiNewList, challengesNewsList ->
                when (apiNewList.isEmpty()) {
                    true -> emptyList()
                    false -> {
                        (apiNewList + challengesNewsList).sortedBy {
                            LocalDateTime.parse(it.publishedAt, DateTimeFormatter.ISO_DATE_TIME)
                        }
                    }
                }
            }
        } else return Mono.just(emptyList())

    }

}
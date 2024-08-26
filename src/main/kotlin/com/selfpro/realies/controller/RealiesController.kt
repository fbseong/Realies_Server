package com.selfpro.realies.controller

import com.selfpro.realies.entity.News
import com.selfpro.realies.service.ChallengesService
import com.selfpro.realies.service.RealiesService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/realies")
class RealiesController @Autowired constructor(
    private val realiesService: RealiesService,
    private val challengesService: ChallengesService
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/recommendation")
    @ResponseBody
    fun getRecommendationRealies(@RequestParam page: Int?): Mono<List<News>> {

//        val challengesList = challengesService.getRecommendationRealies(page?:0)
//        return Mono.just(challengesList)

        if (page != null) {
            //News from NewsAPI
            val apiNewsMono = realiesService.getRecommendationNewsFromNewsAPI(page + 1)

            //ChallengesNews from Challenges DB
            val challengesListMono = Mono.just(challengesService.getRecommendationRealies(page))

            //Combine apiNewMono with challengesMono and Sort by publishedAt
            return apiNewsMono.zipWith(challengesListMono) { apiNewsList, challengesNewsList ->
                when (apiNewsList.isEmpty()) {
                    true -> emptyList()
                    false -> {
                        logger.info("succes: $apiNewsList");

                        (apiNewsList + challengesNewsList).sortedBy {
                            LocalDateTime.parse(it.publishedAt, DateTimeFormatter.ISO_DATE_TIME)
                        }
                    }
                }
            }

        } else return Mono.just(emptyList())
    }

    @GetMapping("/title")
    fun getRealiesTitle(@RequestParam content: String): String {
        return realiesService.getRealiesTitel(content)
    }

}
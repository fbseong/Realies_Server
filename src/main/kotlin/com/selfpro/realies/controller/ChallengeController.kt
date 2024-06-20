package com.selfpro.realies.controller

import com.selfpro.realies.dto.ChallengesDto
import com.selfpro.realies.model.Challenges
import com.selfpro.realies.service.ChallengesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/challenges")
class ChallengeController @Autowired constructor(private val challengeService: ChallengesService) {

    @PostMapping("/upload")
    fun createUser(@RequestBody challengesDto: ChallengesDto): Challenges? {
        return challengeService.createChallenges(challengesDto.run {
            Challenges(
                author = author,
                title = title,
                image = image,
                content = content,
                publishedAt = publishedAt,
                challengeRank = challengeRank
            )
        })
    }
}
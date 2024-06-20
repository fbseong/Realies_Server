package com.selfpro.realies.controller

import com.selfpro.realies.dto.ChallengesDTO
import com.selfpro.realies.entity.Challenges
import com.selfpro.realies.service.ChallengesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/challenges")
class ChallengeController @Autowired constructor(private val challengeService: ChallengesService) {

    @PostMapping("/upload")
    fun createUser(@RequestBody challengesDto: ChallengesDTO): Challenges? {
        return challengeService.createChallenges(challengesDto)
    }
}
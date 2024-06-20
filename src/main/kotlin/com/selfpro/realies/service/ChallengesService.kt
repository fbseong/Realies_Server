package com.selfpro.realies.service

import com.selfpro.realies.dto.ChallengesDTO
import com.selfpro.realies.entity.Challenges
import reactor.core.publisher.Mono

interface ChallengesService {
    fun createChallenges(challengesDTO: ChallengesDTO): Challenges
    fun getAllChallenges(): List<Challenges>
    fun getChallengesById(id: String?): Challenges?
    fun deleteChallengesById(id: String?)

    fun getRecommendationRealies(page: Int): Mono<List<Challenges>>
}
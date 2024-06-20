package com.selfpro.realies.repository

import com.selfpro.realies.model.Challenges
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface ChallengesRepository: MongoRepository<Challenges, String> {
    fun findByChallengeRankOrderByPublishedAtAsc(challengeRank: Int, pageable: Pageable): Page<Challenges>
}
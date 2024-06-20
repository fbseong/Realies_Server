package com.selfpro.realies.service

import com.selfpro.realies.model.Challenges
import com.selfpro.realies.model.Realies

interface ChallengesService {
    fun createChallenges(challenges: Challenges): Challenges
    fun getAllChallenges(): List<Challenges>
    fun getChallengesById(id: String?): Challenges?
    fun deleteChallengesById(id: String?)

    fun getRecommendationRealies(page: Int): List<Challenges>
}
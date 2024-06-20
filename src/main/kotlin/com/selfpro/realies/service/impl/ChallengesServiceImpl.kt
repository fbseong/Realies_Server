package com.selfpro.realies.service.impl

import com.selfpro.realies.model.Challenges
import com.selfpro.realies.model.Realies
import com.selfpro.realies.repository.ChallengesRepository
import com.selfpro.realies.service.ChallengesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ChallengesServiceImpl @Autowired constructor(private val challengesRepository: ChallengesRepository) :
    ChallengesService {
    override fun createChallenges(challenges: Challenges): Challenges {
        return challenges.let { challengesRepository.save(it) }
    }

    override fun getAllChallenges(): List<Challenges> {
        return challengesRepository.findAll()
    }

    override fun getChallengesById(id: String?): Challenges? {
        return id?.let { challengesRepository.findById(it).orElse(null) }
    }

    override fun deleteChallengesById(id: String?) {
        if (id != null) {
            challengesRepository.deleteById(id)
        }
    }

    override fun getRecommendationRealies(page: Int): List<Challenges> {
        val pageable: PageRequest = PageRequest.of(page, 20, Sort.by("publishedAt").ascending())
        val page = challengesRepository.findByChallengeRankOrderByPublishedAtAsc(1, pageable)
        return page.content

    }


}

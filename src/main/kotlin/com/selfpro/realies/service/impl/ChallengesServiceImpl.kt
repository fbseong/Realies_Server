package com.selfpro.realies.service.impl

import com.selfpro.realies.dto.NewsAPIDto
import com.selfpro.realies.model.Challenges
import com.selfpro.realies.model.News
import com.selfpro.realies.repository.ChallengesRepository
import com.selfpro.realies.service.ChallengesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ChallengesServiceImpl @Autowired constructor(private val challengesRepository: ChallengesRepository) : ChallengesService {
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


}

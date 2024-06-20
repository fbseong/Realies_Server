package com.selfpro.realies.repository

import com.selfpro.realies.model.Challenges
import org.springframework.data.mongodb.repository.MongoRepository

interface ChallengesRepository: MongoRepository<Challenges, String> {

}
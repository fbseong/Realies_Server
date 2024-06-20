package com.selfpro.realies.repository

import com.selfpro.realies.entity.Realies
import org.springframework.data.mongodb.repository.MongoRepository

interface RealiesRepository: MongoRepository<Realies, String> {

}
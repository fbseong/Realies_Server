package com.selfpro.realies.repository

import com.selfpro.realies.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*

interface UserRepository : MongoRepository<User, String> {
    fun findByUsername(username: String): User?
}
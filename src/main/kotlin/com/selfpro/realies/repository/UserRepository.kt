package com.selfpro.realies.repository

import com.selfpro.realies.entity.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository:MongoRepository<User,String>{

}
package com.selfpro.realies.repository

import com.selfpro.realies.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository:MongoRepository<User,String>{

}
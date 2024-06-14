package com.selfpro.realies.repository

import com.selfpro.realies.model.News
import org.springframework.data.mongodb.repository.MongoRepository

interface NewsRepository: MongoRepository<News, String> {

}
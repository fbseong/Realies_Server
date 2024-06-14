package com.selfpro.realies.service.impl

import com.selfpro.realies.model.News
import com.selfpro.realies.repository.NewsRepository
import com.selfpro.realies.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NewsServiceImpl @Autowired constructor(private val newsRepository: NewsRepository) : NewsService {
    override fun createNews(user: News?): News? {
        return user?.let { newsRepository.save(it) }
    }

    override fun getAllNews(): List<News> {
        return newsRepository.findAll()
    }

    override fun getNewsById(id: String?): News? {
        return id?.let { newsRepository.findById(it).orElse(null) }
    }

    override fun deleteNewsById(id: String?) {
        if (id != null) {
            newsRepository.deleteById(id)
        }
    }
}
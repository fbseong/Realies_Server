package com.selfpro.realies.service

import com.selfpro.realies.model.News

interface NewsService {
    fun createNews(user: News?): News?
    fun getAllNews(): List<News>
    fun getNewsById(id: String?): News?
    fun deleteNewsById(id: String?)
}
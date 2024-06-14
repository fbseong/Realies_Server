package com.selfpro.realies.controller

import com.selfpro.realies.dto.NewsDto
import com.selfpro.realies.model.News
import com.selfpro.realies.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/news")
class NewsController @Autowired constructor(private val newsService: NewsService) {

    @PostMapping
    fun createUser(@RequestBody newsDto: NewsDto): News? {
        return newsService.createNews(
            newsDto.run {
                News(
                    author = author,
                    title = title,
                    image = image,
                    url = url,
                    content = content
                )
            }
        )
    }

    @GetMapping
    fun getAllUsers(): List<News> {
        return newsService.getAllNews()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String?): News? {
        return newsService.getNewsById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: String?) {
        newsService.deleteNewsById(id)
    }
}
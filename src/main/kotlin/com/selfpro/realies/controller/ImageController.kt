package com.selfpro.realies.controller

import com.selfpro.realies.model.NewsProvider
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/images")
class ImageController {

    @GetMapping("/news")
    fun getNewsImage(): ResponseEntity<ByteArray> {
        val imgFile = ClassPathResource("static/images/donga.png").inputStream.readBytes()
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(imgFile)
    }

    @GetMapping("/provider")
    fun getProviderImage(@RequestParam name: String): ResponseEntity<ByteArray> {
        val providerImage = NewsProvider().getProviderInfo(name)

        val imgFile = ClassPathResource("static/images/$providerImage").inputStream.readBytes()
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(imgFile)
    }
}
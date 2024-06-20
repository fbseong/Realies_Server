package com.selfpro.realies.controller

import com.selfpro.realies.model.ProviderModel
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/images")
class ImageController {

    @GetMapping("/news/{images}")
    @ResponseBody
    fun getNewsImage(@RequestParam images: String): ResponseEntity<ByteArray> {
        val imgFile = ClassPathResource("static/images/donga.png").inputStream.readBytes()
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(imgFile)
    }

    @GetMapping("/provider")
    fun getProviderImage(@RequestParam images: String): ResponseEntity<ByteArray> {
        val providerImage = ProviderModel().getProviderInfo(images)

        val imgFile = ClassPathResource("static/images/$providerImage").inputStream.readBytes()
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(imgFile)
    }
}
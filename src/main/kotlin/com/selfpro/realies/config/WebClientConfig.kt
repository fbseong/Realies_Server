package com.selfpro.realies.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.time.Duration

@Configuration
class WebClientConfig {
    @Bean
    fun webClientBuilder(): WebClient.Builder {
        return WebClient.builder().baseUrl("https://newsapi.org")
    }
    @Bean
    fun webClient(builder:WebClient.Builder): WebClient {
        val httpClient: HttpClient = HttpClient.create()
            .responseTimeout(Duration.ofMillis(20000))
            .proxyWithSystemProperties()
        return builder.clientConnector(ReactorClientHttpConnector(httpClient)).build()
    }
}
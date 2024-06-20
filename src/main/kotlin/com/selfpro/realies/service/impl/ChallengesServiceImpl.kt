package com.selfpro.realies.service.impl

import com.selfpro.realies.dto.ChallengesDTO
import com.selfpro.realies.entity.Challenges
import com.selfpro.realies.repository.ChallengesRepository
import com.selfpro.realies.service.ChallengesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Service
class ChallengesServiceImpl @Autowired constructor(private val challengesRepository: ChallengesRepository) :
    ChallengesService {
    override fun createChallenges(challengesDTO: ChallengesDTO): Challenges {
        return challengesDTO.run {
            //replace currentTime
            val currentDateTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ISO_DATE_TIME
//            challengesDTO.publishedAt = currentDateTime.format(formatter)

            challengesRepository.save(challengesDTO.toChallenges())
        }
    }

    override fun getAllChallenges(): List<Challenges> {
        return challengesRepository.findAll()
    }

    override fun getChallengesById(id: String?): Challenges? {
        return id?.let { challengesRepository.findById(it).orElse(null) }
    }

    override fun deleteChallengesById(id: String?) {
        if (id != null) {
            challengesRepository.deleteById(id)
        }
    }

    override fun getRecommendationRealies(page: Int): Mono<List<Challenges>> {
        val pageable: PageRequest = PageRequest.of(page, 20, Sort.by("publishedAt").ascending())
        val page = challengesRepository.findByChallengeRankOrderByPublishedAtAsc(1, pageable)


        return Mono.fromCallable { page.content }
            .flatMapMany { Flux.fromIterable(it) }
            .collectList()

    }

    fun ChallengesDTO.toChallenges(): Challenges {
        return this.run {
            val currentDateTime = ZonedDateTime.now().withZoneSameInstant(ZoneOffset.UTC)
            val formatter = DateTimeFormatter.ISO_DATE_TIME

            Challenges(
                author = author,
                title = title,
                images = images,
                content = content,
                publishedAt = currentDateTime.format(formatter),
                challengeRank = 5
            )
        }
    }

    fun Challenges.toChallengesDTO(): ChallengesDTO {
        return this.run {
            ChallengesDTO(
                author = author,
                title = title,
                images = images,
                content = content,
            )
        }
    }
}
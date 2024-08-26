package com.selfpro.realies.service.impl

import com.selfpro.realies.entity.Authority
import com.selfpro.realies.entity.User
import com.selfpro.realies.repository.UserRepository
import com.selfpro.realies.request.SignInRequest
import com.selfpro.realies.request.SignUpRequest
import com.selfpro.realies.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserServiceImpl @Autowired constructor(private val userRepository: UserRepository) : UserService {
    private val passwordEncoder = BCryptPasswordEncoder()

    override fun signUp(userRequest: SignUpRequest): User {
        val encryptedPassword = passwordEncoder.encode(userRequest.password)
        val user = User(username = userRequest.username, password = encryptedPassword)
        return userRepository.save(user)
    }

    override fun authenticate(username: String, password: String): User? {
        val user = userRepository.findByUsername(username) ?: return null
        return if (passwordEncoder.matches(password, user.password)) user else null
    }

    override fun signIn(signInRequest: SignInRequest) {
        TODO("Not yet implemented")
    }

    override fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }

    override fun myInfo(): User {
        TODO("Not yet implemented")
    }
}
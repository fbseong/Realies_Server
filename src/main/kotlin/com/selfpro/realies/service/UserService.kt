package com.selfpro.realies.service

import com.selfpro.realies.entity.User
import com.selfpro.realies.request.SignInRequest
import com.selfpro.realies.request.SignUpRequest
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun signUp(userRequest: SignUpRequest): User
    fun signIn(signInRequest: SignInRequest)

    fun authenticate(username: String, password: String): User?

    fun findByUsername(username: String): User?

    fun myInfo(): User
}
package com.selfpro.realies.service

import com.selfpro.realies.entity.User
import com.selfpro.realies.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
interface UserService : UserDetailsService {
    fun createUser(user: User?): User?

    fun getAllUsers(): List<User>

    fun getUserById(id: String?): User?

    fun deleteUserById(id: String?)
}
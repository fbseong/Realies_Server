package com.selfpro.realies.service.impl

import com.selfpro.realies.entity.User
import com.selfpro.realies.repository.UserRepository
import com.selfpro.realies.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service


@Service
class UserServiceImpl @Autowired constructor(private val userRepository: UserRepository) : UserService {


    override fun createUser(user: User?): User? {
        return user?.let { userRepository.save(it) };
    }

    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun getUserById(id: String?): User? {
        return id?.let { userRepository.findById(it).orElse(null) }
    }

    override fun deleteUserById(id: String?) {
        if (id != null) {
            userRepository.deleteById(id)
        }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}
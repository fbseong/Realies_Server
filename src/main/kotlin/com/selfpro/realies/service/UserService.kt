package com.selfpro.realies.service

import com.selfpro.realies.model.User

interface UserService {
    fun createUser(user: User?): User?
    fun getAllUsers():List<User>
    fun getUserById(id: String?): User?
    fun deleteUserById(id: String?)
}
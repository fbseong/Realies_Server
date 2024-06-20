package com.selfpro.realies.controller

import com.selfpro.realies.entity.User
import com.selfpro.realies.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody user: User?): User? {
        return userService.createUser(user)
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String?): User? {
        return userService.getUserById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: String?) {
        userService.deleteUserById(id)
    }
}
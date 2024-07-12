package com.selfpro.realies.controller

import com.selfpro.realies.entity.User
import com.selfpro.realies.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(private val userService: UserService) {

}


data class AuthRequest(val username: String, val password: String)
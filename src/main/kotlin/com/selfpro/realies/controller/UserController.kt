package com.selfpro.realies.controller

import com.selfpro.realies.entity.User
import com.selfpro.realies.request.SignInRequest
import com.selfpro.realies.request.SignUpRequest
import com.selfpro.realies.response.TokenResponse
import com.selfpro.realies.service.UserService
import com.selfpro.realies.util.JwtUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize


@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
    private val userService: UserService,
    private val jwtUtil: JwtUtil
) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<User> {
        val existingUser = userService.findByUsername(signUpRequest.username)
        if (existingUser != null) {
            return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(userService.signUp(signUpRequest))
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInRequest): ResponseEntity<TokenResponse> {
        val user = userService.authenticate(signInRequest.username, signInRequest.password)
            ?: return ResponseEntity.status(401).body(TokenResponse("null"))

        val token = jwtUtil.generateToken(user.username)
        return ResponseEntity.ok(TokenResponse(token))
    }

    @GetMapping("my-info")
    fun myInfo(): ResponseEntity<User> {
        return ResponseEntity.ok(userService.myInfo())
    }
}

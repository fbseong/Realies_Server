package com.selfpro.realies.util

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*
import org.springframework.beans.factory.annotation.Value
import io.jsonwebtoken.Claims
import org.springframework.security.core.userdetails.UserDetails

@Component
class JwtUtil {

    @Value("\${jwt.secret}")
    private val secret: String? = null

    @Value("\${jwt.expiration}")
    private val expirationTime: Long = 0

    fun generateToken(username: String): String {
        val claims = Jwts.claims().setSubject(username)
        val now = Date()
        val expiryDate = Date(now.time + expirationTime * 1000)

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = getUsernameFromToken(token)
        return (username == userDetails.username && !isTokenExpired(token))
    }

    private fun isTokenExpired(token: String): Boolean {
        val expiration = getClaimsFromToken(token).expiration
        return expiration.before(Date())
    }

    fun getUsernameFromToken(token: String): String {
        return getClaimsFromToken(token).subject
    }

    private fun getClaimsFromToken(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .body
    }
}
package com.selfpro.realies.util

import com.selfpro.realies.service.UserService
import io.jsonwebtoken.io.IOException
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtRequestFilter(
    private val jwtUtil: JwtUtil,
    private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val header = request.getHeader("Authorization")
        var username: String? = null
        var jwt: String? = null

        // JWT가 Bearer 토큰인지 확인합니다.
        if (header != null && header.startsWith("Bearer ")) {
            jwt = header.substring(7)
            try {
                username = jwtUtil.getUsernameFromToken(jwt)
            } catch (e: IllegalArgumentException) {
                println("Unable to get JWT Token")
            } catch (e: Exception) {
                println("JWT Token has expired")
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String")
        }

        // JWT가 유효한지 확인합니다.
        if (username != null && SecurityContextHolder.getContext().authentication == null) {
//            logger.warn("jwt available")

            val userDetails = userDetailsService.loadUserByUsername(username)

            if (jwtUtil.validateToken(jwt!!, userDetails)) {
                val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication

                logger.warn("name: ${jwtUtil.getUsernameFromToken(jwt)}")
            }
        }
        chain.doFilter(request, response)
    }
}
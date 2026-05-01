package br.com.raizes.backend.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
    request: HttpServletRequest,
    response: HttpServletResponse,
    filterChain: FilterChain
) {

    val path = request.requestURI

    if (
        path.contains("/auth") ||
        path.startsWith("/produtos") ||
        path.startsWith("/pedidos") ||
        path.contains("/users") ||
        path.contains("/swagger") ||
        path.contains("/v3")
    ) {
        filterChain.doFilter(request, response)
        return
    }

    val authHeader = request.getHeader("Authorization")

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        filterChain.doFilter(request, response)
        return
    }

    val token = authHeader.substring(7)

    try {
        val email = JwtUtil.extractEmail(token)
    } catch (e: Exception) {
        response.status = 401
        return
    }

    filterChain.doFilter(request, response)
}
}
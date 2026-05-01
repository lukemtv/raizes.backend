package br.com.raizes.backend.dto

data class LoginResponse(
    val accessToken: String,
    val tokenType: String = "Bearer",
    val userId: Long,
    val nome: String,
    val email: String
)

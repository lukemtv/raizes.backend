package br.com.raizes.backend.controller

import br.com.raizes.backend.dto.LoginRequest
import br.com.raizes.backend.dto.LoginResponse
import br.com.raizes.backend.repository.UserRepository
import br.com.raizes.backend.security.JwtUtil
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "E-mail ou senha inválidos")

        val senhaValida = passwordEncoder.matches(request.senha, user.senha)

        if (!senhaValida) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "E-mail ou senha inválidos")
        }

        return LoginResponse(
            accessToken = JwtUtil.generateToken(user.email),
            userId = user.id,
            nome = user.nome,
            email = user.email
        )
    }
}
package br.com.raizes.backend.controller

import br.com.raizes.backend.entity.User
import br.com.raizes.backend.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    val userRepository: UserRepository,
    val passwordEncoder: BCryptPasswordEncoder
) {

    @PostMapping
    fun criar(@RequestBody user: User): User {
        val userCriptografado = User(
            nome = user.nome,
            email = user.email,
            senha = passwordEncoder.encode(user.senha)
        )
        return userRepository.save(userCriptografado)
    }

    @GetMapping
    fun listar(): List<User> {
        return userRepository.findAll()
    }
}
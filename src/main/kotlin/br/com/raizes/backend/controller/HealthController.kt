package br.com.raizes.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthController {

    @GetMapping
    fun status(): Map<String, String> {
        return mapOf(
            "status" to "OK",
            "sistema" to "Raizes Backend"
        )
    }
}

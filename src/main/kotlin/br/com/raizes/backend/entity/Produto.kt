package br.com.raizes.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "produtos")
class Produto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false)
    val descricao: String,

    @Column(nullable = false)
    val preco: BigDecimal,

    @Column(nullable = false)
    val ativo: Boolean = true
)

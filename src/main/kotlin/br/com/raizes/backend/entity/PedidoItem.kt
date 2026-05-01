package br.com.raizes.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "pedido_itens")
class PedidoItem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    val pedido: Pedido,

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    val produto: Produto,

    @Column(nullable = false)
    val quantidade: Int,

    @Column(nullable = false)
    val precoUnitario: BigDecimal,

    @Column(nullable = false)
    val subtotal: BigDecimal
)

package br.com.raizes.backend.entity

import br.com.raizes.backend.enums.StatusPagamento
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "pagamentos")
class Pagamento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    val pedido: Pedido,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: StatusPagamento,

    @Column(nullable = false)
    val valor: BigDecimal,

    @Column(nullable = false)
    val gateway: String = "MOCK",

    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now()
)

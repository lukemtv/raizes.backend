package br.com.raizes.backend.entity

import br.com.raizes.backend.enums.CanalPedido
import br.com.raizes.backend.enums.StatusPedido
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "pedidos")
class Pedido(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val canalPedido: CanalPedido,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: StatusPedido = StatusPedido.AGUARDANDO_PAGAMENTO,

    @Column(nullable = false)
    var valorTotal: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now()
)

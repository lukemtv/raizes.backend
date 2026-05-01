package br.com.raizes.backend.repository

import br.com.raizes.backend.entity.Pedido
import br.com.raizes.backend.enums.CanalPedido
import org.springframework.data.jpa.repository.JpaRepository

interface PedidoRepository : JpaRepository<Pedido, Long> {
    fun findByCanalPedido(canalPedido: CanalPedido): List<Pedido>
}

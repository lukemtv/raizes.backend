package br.com.raizes.backend.dto

import br.com.raizes.backend.enums.CanalPedido

data class CriarPedidoRequest(
    val canalPedido: CanalPedido,
    val itens: List<PedidoItemRequest>
)

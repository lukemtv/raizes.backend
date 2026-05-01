package br.com.raizes.backend.dto

data class PedidoItemRequest(
    val produtoId: Long,
    val quantidade: Int
)

package br.com.raizes.backend.repository

import br.com.raizes.backend.entity.PedidoItem
import org.springframework.data.jpa.repository.JpaRepository

interface PedidoItemRepository : JpaRepository<PedidoItem, Long>

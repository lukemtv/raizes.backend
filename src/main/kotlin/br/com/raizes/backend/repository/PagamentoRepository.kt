package br.com.raizes.backend.repository

import br.com.raizes.backend.entity.Pagamento
import org.springframework.data.jpa.repository.JpaRepository

interface PagamentoRepository : JpaRepository<Pagamento, Long>

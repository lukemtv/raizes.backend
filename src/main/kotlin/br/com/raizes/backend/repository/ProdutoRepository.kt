package br.com.raizes.backend.repository

import br.com.raizes.backend.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository : JpaRepository<Produto, Long>

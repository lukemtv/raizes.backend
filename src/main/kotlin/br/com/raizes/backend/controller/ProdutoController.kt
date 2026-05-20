package br.com.raizes.backend.controller

import br.com.raizes.backend.entity.Produto
import br.com.raizes.backend.repository.ProdutoRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(
    val produtoRepository: ProdutoRepository
) {

    @PostMapping
    fun criar(@RequestBody produto: Produto): Produto {
        return produtoRepository.save(produto)
    }

    @GetMapping
    fun listar(): List<Produto> {
        return produtoRepository.findAll()
    }
}
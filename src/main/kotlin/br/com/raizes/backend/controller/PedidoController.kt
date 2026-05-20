package br.com.raizes.backend.controller

import br.com.raizes.backend.dto.CriarPedidoRequest
import br.com.raizes.backend.entity.Pedido
import br.com.raizes.backend.entity.PedidoItem
import br.com.raizes.backend.enums.StatusPedido
import br.com.raizes.backend.repository.*
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/pedidos")
class PedidoController(
    val pedidoRepository: PedidoRepository,
    val produtoRepository: ProdutoRepository,
    val pedidoItemRepository: PedidoItemRepository
) {

    @PostMapping
    fun criar(@RequestBody request: CriarPedidoRequest): Pedido {

        val pedido = Pedido(
            canalPedido = request.canalPedido,
            status = StatusPedido.AGUARDANDO_PAGAMENTO
        )

        val pedidoSalvo = pedidoRepository.save(pedido)

        var total = BigDecimal.ZERO

        request.itens.forEach { item ->
            val produto = produtoRepository.findById(item.produtoId)
                .orElseThrow { RuntimeException("Produto não encontrado") }

            val subtotal = produto.preco.multiply(BigDecimal(item.quantidade))

            val pedidoItem = PedidoItem(
                pedido = pedidoSalvo,
                produto = produto,
                quantidade = item.quantidade,
                precoUnitario = produto.preco,
                subtotal = subtotal
            )

            pedidoItemRepository.save(pedidoItem)

            total = total.add(subtotal)
        }

        pedidoSalvo.valorTotal = total
        return pedidoRepository.save(pedidoSalvo)
    }
    @GetMapping
    fun listar(): List<Pedido> {
        return pedidoRepository.findAll()
    }

    @GetMapping("/canal")
    fun listarPorCanal(@RequestParam canalPedido: String): List<Pedido> {
        return pedidoRepository.findByCanalPedido(
            br.com.raizes.backend.enums.CanalPedido.valueOf(canalPedido)
        )
    }
}

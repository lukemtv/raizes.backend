package br.com.raizes.backend.controller

import br.com.raizes.backend.entity.Pagamento
import br.com.raizes.backend.enums.StatusPagamento
import br.com.raizes.backend.enums.StatusPedido
import br.com.raizes.backend.repository.PagamentoRepository
import br.com.raizes.backend.repository.PedidoRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pedidos")
class PagamentoController(
    val pedidoRepository: PedidoRepository,
    val pagamentoRepository: PagamentoRepository
) {

    @PostMapping("/{id}/pagar")
    fun pagar(@PathVariable id: Long): Pagamento {
        val pedido = pedidoRepository.findById(id)
            .orElseThrow { RuntimeException("Pedido não encontrado") }

        pedido.status = StatusPedido.PAGO
        val pedidoAtualizado = pedidoRepository.save(pedido)

        val pagamento = Pagamento(
            pedido = pedidoAtualizado,
            status = StatusPagamento.APROVADO,
            valor = pedidoAtualizado.valorTotal
        )

        return pagamentoRepository.save(pagamento)
    }
}

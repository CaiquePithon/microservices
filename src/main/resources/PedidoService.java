package meu.curso.microservicos.pedido.service;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvarPedido(Pedido pedido) {
        // Lógica para salvar um pedido

        if (pedido.getItens() != null) {
            for (Item item : pedido.getItens()) {
                item.setPedido(pedido); // Estabelece a relação bidirecional
            }
            return pedidoRepository.save(pedido);
        }else {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um item.");
        }
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    } 
    
}

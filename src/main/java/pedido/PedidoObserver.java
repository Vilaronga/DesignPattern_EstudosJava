package pedido;

@FunctionalInterface
public interface PedidoObserver {

    void atualizar(Pedido pedido);
}
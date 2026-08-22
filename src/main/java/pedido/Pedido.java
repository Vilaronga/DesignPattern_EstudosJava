package pedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Status status;

    private final List<PedidoObserver> pedidoObservers = new ArrayList<>();

    public void addPedidoObserver(PedidoObserver pedidoObserver) {
        this.pedidoObservers.add(pedidoObserver);
    }

    public void alterarStatus(Status status){
        if(!pedidoObservers.isEmpty()){
            this.status = status;

            for (PedidoObserver pedidoObserver : pedidoObservers) {
                pedidoObserver.atualizar(this);
            }
        }
    }

    public Status getStatus() {
        return status;
    }
}

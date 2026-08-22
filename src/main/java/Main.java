import pagamento.*;
import pedido.*;

public class Main {

    public static void main(String[] args) {

        Pagamento pagamento = new Pagamento();
        System.out.println("\n\n============================\n");

        //Simulando sem forma de pagamento
        pagamento.realizarPagamento(500);
        System.out.println("\n\n============================\n");

        //Simulando com valor inferior a 0
        pagamento.setStrategy(new Pix());
        pagamento.realizarPagamento(-5);
        System.out.println("\n\n============================\n");

        //Simulando pagamento pix
        pagamento.realizarPagamento(500);

        System.out.println("\n\n============================\n");

        //Simulando pagamento crédito
        pagamento.setStrategy(Cartao.Credito);
        pagamento.realizarPagamento(500);

        System.out.println("\n\n============================\n");

        //Simulando pagamento débito
        pagamento.setStrategy(Cartao.Debito);
        pagamento.realizarPagamento(500);

        System.out.println("\n\n============================\n");


        Pedido pedido = new Pedido();
        pedido.addPedidoObserver(pedidoAtual -> System.out.printf("O status do seu pedido agora é: %s%n", pedidoAtual.getStatus()));
        pedido.addPedidoObserver(pedidoAtual -> {
            if (pedidoAtual.getStatus() == Status.Em_Preparacao) {
                System.out.println("Atualizando quantidade no estoque...");
            }
        });
        pedido.alterarStatus(Status.Em_Preparacao);
        pedido.alterarStatus(Status.Enviado);
        pedido.alterarStatus(Status.Entregue);
        System.out.println("\n\n============================\n");

    }
}

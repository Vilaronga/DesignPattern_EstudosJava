package pagamento;

public final class Pix implements PagamentoStrategy {

    @Override
    public void pagar(double valor){
        System.out.printf("Pagamento Pix aprovado no valor de: %.2f", valor);
    }
}

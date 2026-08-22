package pagamento;

public final class Pagamento {

    private PagamentoStrategy strategy;


    public Pagamento(){
    }

    public void setStrategy(PagamentoStrategy strategy) {
        this.strategy = strategy;
    }

    public void realizarPagamento(double valor){
        try{
            if (this.strategy == null) {
                throw new IllegalStateException("Forma de pagamento não definida!");
            }

            if (valor <= 0) {
                throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero!");
            }

            strategy.pagar(valor);

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}

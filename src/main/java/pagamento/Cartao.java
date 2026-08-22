package pagamento;

public enum Cartao implements PagamentoStrategy {
    Credito((valor) -> System.out.printf("Pagamento crédito aprovado no valor de %.2f", valor)),
    Debito((valor) -> System.out.printf("Pagamento débito aprovado no valor de %.2f", valor));

    private final PagamentoStrategy strategy;

    Cartao(PagamentoStrategy strategy) {
        this.strategy = strategy;
    }

    public void pagar(double valor){
        this.strategy.pagar(valor);
    }

}

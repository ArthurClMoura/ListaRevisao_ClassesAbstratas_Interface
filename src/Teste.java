public class Teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana Souza", "123.456.789-00");
        IBancoGeral banco = new BancoItau();

        ContaAbstrata poupanca = banco.abrirConta(cliente, "001", 1000.0, "poupanca");
        ContaAbstrata corrente = banco.abrirConta(cliente, "002", 1000.0, "corrente");

        System.out.println("Cliente: " + cliente.getNome() + " (" + cliente.getCpf() + ")");
        imprimir(poupanca);
        imprimir(corrente);

        System.out.println();
        System.out.println("Deposito de 200 na poupanca: " + banco.depositar(poupanca, 200));
        System.out.println("Saque de 1500 na poupanca: " + banco.sacar(poupanca, 1500));
        System.out.println("Saque de 500 na poupanca: " + banco.sacar(poupanca, 500));
        imprimir(poupanca);

        System.out.println();
        System.out.println("Saque de 1800 na corrente: " + banco.sacar(corrente, 1800));
        System.out.println("Saque de 2500 na corrente: " + banco.sacar(corrente, 2500));
        imprimir(corrente);
    }

    private static void imprimir(ContaAbstrata conta) {
        System.out.println(
                conta.getClass().getSimpleName()
                        + " " + conta.getNumeroConta()
                        + " | saldo: " + conta.getSaldo()
                        + " | limite: " + conta.obterLimite()
        );
    }
}

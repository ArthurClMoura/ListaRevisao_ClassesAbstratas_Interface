public class BancoItau implements IBancoGeral {
    public static final double CHEQUE_ESPECIAL_PADRAO = 1000.0;

    @Override
    public ContaAbstrata abrirConta(Cliente c, String numeroConta, double saldoInicial, String tipo) {
        if (c == null || numeroConta == null || numeroConta.isBlank() || saldoInicial < 0 || tipo == null) {
            return null;
        }

        String tipoNormalizado = tipo.trim().toLowerCase().replace("ç", "c").replace(" ", "");
        if (tipoNormalizado.equals("poupanca")) {
            return new Poupanca(numeroConta, saldoInicial, c);
        }
        if (tipoNormalizado.equals("corrente") || tipoNormalizado.equals("contacorrente")) {
            return new ContaCorrente(numeroConta, saldoInicial, c, CHEQUE_ESPECIAL_PADRAO);
        }
        return null;
    }

    @Override
    public boolean depositar(ContaAbstrata c, double valor) {
        if (c == null || valor <= 0) {
            return false;
        }
        c.depositar(valor);
        return true;
    }

    @Override
    public boolean sacar(ContaAbstrata c, double valor) {
        if (c == null || valor <= 0 || valor > c.obterLimite()) {
            return false;
        }
        c.sacar(valor);
        return true;
    }
}

public class ContaCorrente extends ContaAbstrata {
    private double limChequeEspecial;

    public ContaCorrente(String numeroConta, double saldo, Cliente cliente, double limChequeEspecial) {
        super(numeroConta, saldo, cliente);
        this.limChequeEspecial = limChequeEspecial;
    }

    public double getLimChequeEspecial() {
        return limChequeEspecial;
    }

    public void setLimChequeEspecial(double limChequeEspecial) {
        this.limChequeEspecial = limChequeEspecial;
    }

    @Override
    public double obterLimite() {
        return getSaldo() + limChequeEspecial;
    }
}

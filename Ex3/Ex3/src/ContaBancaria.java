public class ContaBancaria {
    private int numConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(int numConta, String nomeTitular, double saldoInicial) {
        this.numConta = numConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;

    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " aprovado");

    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " aprovado");

        } else {
            System.out.println("Saque não realizado. Saldo insuficiente");

        }

    }

    public double consultarSaldo() {
        return saldo;

    }

}
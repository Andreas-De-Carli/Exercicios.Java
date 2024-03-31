import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número da conta: ");
        int numConta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.println("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(numConta, nomeTitular, saldoInicial);

        int opcao;
        do {
            System.out.println("\nMENU ");
            System.out.println("1. Depositar ");
            System.out.println("2. Sacar ");
            System.out.println("3. Consultar saldo ");
            System.out.println("4. Sair ");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a quantia que deseja depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 2:
                    System.out.println("Informe a quantia que deseja sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 3:
                    double saldoAtual = conta.consultarSaldo();
                    System.out.println("Saldo atual: R$" + saldoAtual);
                    break;

                case 4:
                    System.out.println("Operação cancelada");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;

            }

        } while (opcao != 4);

        scanner.close();

    }

}

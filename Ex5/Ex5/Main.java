import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a marca do carro: ");
        String marca = scanner.nextLine();

        System.out.print("Informe o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Informe o ano do carro: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Informe a placa do carro: ");
        String placa = scanner.nextLine();

        Carro carro1 = new Carro(marca, modelo, ano, placa);

        
        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Acelerar");
            System.out.println("2. Frear");
            System.out.println("3. Exibir Informações do Carro");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Informe o quanto deseja acelerar: ");
                    int aceleracao = scanner.nextInt();
                    carro1.acelerar(aceleracao);
                    break;
                case 2:
                    System.out.print("Informe o quanto deseja frear: ");
                    int desaceleracao = scanner.nextInt();
                    carro1.frear(desaceleracao);
                    break;
                case 3:
                    carro1.exibirInfo();
                    break;
                case 4:
                    System.out.println("Programa encerrado");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
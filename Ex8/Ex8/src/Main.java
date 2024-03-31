import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Pizza> pizzas = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
   
        adicionarPizzasPreCadastradas();

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar Pedido");
            System.out.println("2. Cancelar Pedido");
            System.out.println("3. Gerar Relatório de Pedidos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarPedido();
                    break;
                case 2:
                    cancelarPedido();
                    break;
                case 3:
                    gerarRelatorioPedidos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void adicionarPizzasPreCadastradas() {
        pizzas.add(new Pizza("Margarita", 20.0, List.of("Molho de tomate", "Queijo", "Manjericão")));
        pizzas.add(new Pizza("Calabresa", 40.0, List.of("Molho de tomate", "Queijo", "Calabresa")));
        pizzas.add(new Pizza("Portuguesa", 25.0, List.of("Molho de tomate", "Queijo", "Presunto", "Ovo", "Cebola", "Azeitona")));
    }

    public static void adicionarPedido() {
        exibirMenuPizzas();
        System.out.print("Escolha o número da pizza desejada: ");
        int escolhaPizza = scanner.nextInt();
        scanner.nextLine(); 

        if (escolhaPizza < 1 || escolhaPizza > pizzas.size()) {
            System.out.println("Opção inválida");
            return;
        }

        Pizza pizzaEscolhida = pizzas.get(escolhaPizza - 1);

        System.out.print("Escolha o tamanho da pizza (Pequena/Média/Grande): ");
        String tamanhoPizza = scanner.nextLine();

        System.out.print("Digite o endereço de entrega: ");
        String enderecoEntrega = scanner.nextLine();

        Pedido pedido = new Pedido(pizzaEscolhida, tamanhoPizza, enderecoEntrega);
        pedidos.add(pedido);
        System.out.println("Pedido adicionado com sucesso");
    }

    public static void cancelarPedido() {
        System.out.print("Digite o número do pedido a ser cancelado: ");
        int numeroPedido = scanner.nextInt();

        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if (pedido.getNumeroPedido() == numeroPedido) {
                pedidos.remove(i);
                System.out.println("Pedido cancelado com sucesso");
                return;
            }
        }

        System.out.println("Pedido não encontrado");
    }

    public static void gerarRelatorioPedidos() {
        System.out.println("======= Relatório de Pedidos =======");
        System.out.println("Número total de pedidos: " + pedidos.size());
        if (!pedidos.isEmpty()) {
            double totalValorPedidos = 0;
            for (Pedido pedido : pedidos) {
                totalValorPedidos += pedido.getValor();
            }
            double mediaValorPedidos = totalValorPedidos / pedidos.size();
            System.out.println("Média de preço dos pedidos: R$" + mediaValorPedidos);
        }
        System.out.println("==============================");
    }

    public static void exibirMenuPizzas() {
        System.out.println("\n=== MENU DE PIZZAS ===");
        for (int i = 0; i < pizzas.size(); i++) {
            Pizza pizza = pizzas.get(i);
            System.out.println((i + 1) + ". " + pizza.getNome() + " - R$" + pizza.getValor());
        }
    }
}
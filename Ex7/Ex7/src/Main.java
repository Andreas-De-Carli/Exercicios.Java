import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Produto> estoque = new ArrayList<>();
    private static int codigoAtual = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidadeEmEstoque = scanner.nextInt();
        scanner.nextLine(); 
        Produto produto = new Produto(nome, codigoAtual++, preco, quantidadeEmEstoque);
        estoque.add(produto);
        System.out.println("Produto adicionado com sucesso");
    }

    public static void atualizarProduto() {
        System.out.print("Informe o código do produto a ser atualizado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 

        Produto produtoParaAtualizar = null;
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                produtoParaAtualizar = produto;
                break;
            }
        }

        if (produtoParaAtualizar != null) {
            System.out.print("Novo preço do produto: ");
            double novoPreco = scanner.nextDouble();
            System.out.print("Nova quantidade em estoque: ");
            int novaQuantidade = scanner.nextInt();
            produtoParaAtualizar.setPreco(novoPreco);
            produtoParaAtualizar.setQuantidadeEmEstoque(novaQuantidade);
            System.out.println("Produto atualizado com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public static void removerProduto() {
        System.out.print("Digite o código do produto a ser removido: ");
        int codigo = scanner.nextInt();

        for (int i = 0; i < estoque.size(); i++) {
            Produto produto = estoque.get(i);
            if (produto.getCodigo() == codigo) {
                estoque.remove(i);
                System.out.println("Produto removido com sucesso");
                return;
            }
        }

        System.out.println("Produto não encontrado");
    }

    public static void exibirEstoque() {
        System.out.println("======= Estoque Atual =======");
        for (Produto produto : estoque) {
            System.out.println("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() +
                    ", Preço: " + produto.getPreco() + ", Quantidade em Estoque: " + produto.getQuantidadeEmEstoque());
        }
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Exibir Estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    exibirEstoque();
                    break;
                case 5:
                    System.out.println("Encerrando operação");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do jogador: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a pontuação inicial: ");
        int pontuacao = scanner.nextInt();

        System.out.println("Digite o nível inicial: ");
        int nivel = scanner.nextInt();

        Jogador jogador = new Jogador(nome, pontuacao, nivel);

        jogador.exibirInformacoes();

        jogador.aumentarPontuacao(50);
        jogador.subirNivel();

        System.out.println("\nInformações atualizadas: ");
        jogador.exibirInformacoes();

        scanner.close();

    }

}
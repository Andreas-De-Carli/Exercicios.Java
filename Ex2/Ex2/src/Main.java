import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o título do livro:");
        String titulo = scanner.nextLine();

        System.out.println("Informe o autor do livro:");
        String autor = scanner.nextLine();

        System.out.println("Informe o ano de publicação do livro:");
        int anoPublicacao = scanner.nextInt();

        Livro livro = new Livro(titulo, autor, anoPublicacao);
        livro.exibirInfo();

        scanner.close();

    }
    
}
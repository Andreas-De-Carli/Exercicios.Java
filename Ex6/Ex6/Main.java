import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Agenda agenda = new Agenda();

        while (true) {
            System.out.print("Informe o nome do contato (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Informe o telefone do contato: ");
            String telefone = scanner.nextLine();

            Contato novoContato = new Contato(nome, telefone);
            agenda.adicionarContato(novoContato);
        }

        System.out.print("Informe o nome do contato a ser buscado: ");
        String nomeBusca = scanner.nextLine();
        Contato contatoEncontrado = agenda.buscarContato(nomeBusca);
        if (contatoEncontrado != null) {
            System.out.println("Contato encontrado:");
            System.out.println("Nome: " + contatoEncontrado.getNome());
            System.out.println("Telefone: " + contatoEncontrado.getTelefone());
        } else {
            System.out.println("Contato não encontrado");
        }

        scanner.close();
    }
}
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcaoEscolhida = 0;
        do {
            System.out.println("Digite a opção escolhida: ");
            System.out.println("Opção 1 - Cadastrar novo autor");
            System.out.println("Opção 2 - Buscar autor por nome");
            System.out.println("Opção 3 - Cadastrar novo livro");
            System.out.println("Opção 0 - Sair");
            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEscolhida) {
                case 1:
                    System.out.println();
                    System.out.println("Iniciando cadastro de autor");
                    System.out.println("Digite o nome do autor: ");
                    String nomeAutor = scanner.nextLine();
                    System.out.println();

                    break;
                case 2:
                    System.out.println("Iniciando busca de autor");
                    System.out.println("Digite o nome do autor que deseja buscar: ");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Iniciando cadastro de livro");
                    System.out.println("Digite o nome do livro: ");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida");

            }

        }while (opcaoEscolhida != 0) ;
    }

}
import tech.ada.imdb.model.Ator;
import tech.ada.imdb.model.Diretor;
import tech.ada.imdb.model.Filme;
import tech.ada.imdb.model.Genero;
import tech.ada.imdb.negocio.AtorNegocio;
import tech.ada.imdb.negocio.DiretorNegocio;
import tech.ada.imdb.negocio.FilmeNegocio;
import tech.ada.imdb.persistencia.AtorBancoDeDados;
import tech.ada.imdb.persistencia.DiretorBancoDeDados;
import tech.ada.imdb.persistencia.FilmeBancoDeDados;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static AtorNegocio atorNegocio;
    private static DiretorNegocio diretorNegocio;
    private static FilmeNegocio filmeNegocio;
    private static Scanner scanner;

    public static void main(String[] args) {
        AtorBancoDeDados atorBancoDeDados = new AtorBancoDeDados();
        DiretorBancoDeDados diretorBancoDeDados = new DiretorBancoDeDados();
        FilmeBancoDeDados filmeBancoDeDados = new FilmeBancoDeDados();

        filmeNegocio = new FilmeNegocio(filmeBancoDeDados);
        atorNegocio = new AtorNegocio(atorBancoDeDados);
        diretorNegocio = new DiretorNegocio(diretorBancoDeDados);

        scanner = new Scanner(System.in);

        int opcaoEscolhida = 0;
        do {
            System.out.println("Digite a opção escolhida: ");
            System.out.println("Opção 1 - Cadastrar novo autor");
            System.out.println("Opção 2 - Cadastrar novo Diretor");
            System.out.println("Opção 3 - Cadastrar novo Filme");
            System.out.println("Opção 4 - Associar Filme a Diretor");
            System.out.println("Opção 5 - Associar Filme a Ator");
            System.out.println("Opção 6 - Buscar Filme por nome");
            System.out.println("Opção 0 - Sair");
            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEscolhida) {
                case 1:
                    System.out.println("Iniciando cadastro de Ator");
                    cadastroAtor();
                    break;
                case 2:
                    System.out.println("Iniciando cadastro de Diretor");
                    cadastroDiretor();
                    break;
                case 3:
                    System.out.println("Iniciando cadastro de Filme");
                    cadastroFilme();
                    break;
                case 4:
                    System.out.println("Iniciando associação de Filme a Diretor");
                    associarFilmeDiretor();
                    break;
                case 5:
                    System.out.println("Iniciando associação de Filme a Ator");
                    associarFilmeAtor();
                    break;
                case 6:
                    System.out.println("Iniciando busca de Filme por nome");
                    buscarFilmePorNome();
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (opcaoEscolhida != 0);
    }

    public static void cadastroAtor() {
        System.out.println("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine();

        System.out.println("Digite a data de nascimento do autor (yyyy-MM-dd): ");
        String dataNascimento = scanner.nextLine();

        System.out.println("Digite o sexo do autor: ");
        String sexo = scanner.nextLine();

        Ator ator = new Ator(nomeAutor, dataNascimento, sexo, new ArrayList<>());

        atorNegocio.salvar(ator);
    }

    public static void cadastroDiretor() {
        System.out.println("Digite o nome do diretor: ");
        String nomeDiretor = scanner.nextLine();

        System.out.println("Digite a data de nascimento do diretor (yyyy-MM-dd): ");
        String dataNascimento = scanner.nextLine();

        System.out.println("Digite o sexo do diretor: ");
        String sexo = scanner.nextLine();

        Diretor diretor = new Diretor(nomeDiretor, dataNascimento, sexo, new ArrayList<>());

        diretorNegocio.salvar(diretor);
    }

    public static void cadastroFilme() {
        System.out.println("Digite o nome do filme: ");
        String nomeFilme = scanner.nextLine();

        System.out.println("Digite a data de lançamento do filme (yyyy-MM-dd): ");
        String dataLancamento = scanner.nextLine();

        System.out.println("Digite o orçamento do filme: ");
        double orcamento = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a descrição do filme: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite o gênero do filme(ACAO, AVENTURA, COMEDIA, DRAMA, FICCAO, TERROR): ");
        String generoInput = scanner.nextLine().toUpperCase();
        Genero genero = Genero.valueOf(generoInput);

        System.out.println("Digite o nome do diretor do filme: ");
        String nomeDiretor = scanner.nextLine();
        ArrayList<Diretor> diretor = diretorNegocio.encontrarDiretorPorNome(nomeDiretor);

        Filme filme = new Filme(nomeFilme, dataLancamento, orcamento, descricao, genero, diretor);

        filmeNegocio.salvarFilme(filme);
    }

    public static void associarFilmeDiretor() {
        System.out.println("Digite o nome do filme: ");
        String nomeFilme = scanner.nextLine();
        ArrayList<Filme> filmes = filmeNegocio.buscarFilmePorNome(nomeFilme);

        if (filmes.isEmpty()) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.println("Digite o nome do diretor: ");
        String nomeDiretor = scanner.nextLine();
        ArrayList<Diretor> diretores = diretorNegocio.encontrarDiretorPorNome(nomeDiretor);

        if (diretores.isEmpty()) {
            System.out.println("Diretor não encontrado.");
            return;
        }

        Filme filme = filmes.getFirst();
        Diretor diretor = diretores.getFirst();
        filme.setDiretor(diretor);
        System.out.println("Diretor associado ao filme com sucesso.");
    }


    public static void associarFilmeAtor() {
    System.out.println("Digite o nome do filme: ");
    String nomeFilme = scanner.nextLine();
    ArrayList<Filme> filmes = filmeNegocio.buscarFilmePorNome(nomeFilme);

    if (filmes.isEmpty()) {
        System.out.println("Filme não encontrado.");
        return;
    }

    System.out.println("Filmes encontrados:");
    for (int i = 0; i < filmes.size(); i++) {
        System.out.println((i + 1) + ". " + filmes.get(i).getNomeFilme());
    }
    System.out.println("Escolha o número do filme: ");
    int filmeEscolhido = scanner.nextInt();
    scanner.nextLine();

    if (filmeEscolhido < 1 || filmeEscolhido > filmes.size()) {
        System.out.println("Escolha inválida.");
        return;
    }

    Filme filme = filmes.get(filmeEscolhido - 1);

    System.out.println("Digite o nome do ator: ");
    String nomeAtor = scanner.nextLine();
    ArrayList<Ator> atores = atorNegocio.findAtoresByName(nomeAtor);

    if (atores.isEmpty()) {
        System.out.println("Ator não encontrado.");
        return;
    }

    System.out.println("Atores encontrados:");
    for (int i = 0; i < atores.size(); i++) {
        System.out.println((i + 1) + ". " + atores.get(i).getNome());
    }
    System.out.println("Escolha o número do ator: ");
    int atorEscolhido = scanner.nextInt();
    scanner.nextLine();
    if (atorEscolhido < 1 || atorEscolhido > atores.size()) {
        System.out.println("Escolha inválida.");
        return;
    }

    Ator ator = atores.get(atorEscolhido - 1);
    filme.getAtores().add(ator);
    System.out.println("Ator associado ao filme com sucesso.");
}

    public static void buscarFilmePorNome() {
        System.out.println("Digite o nome do filme: ");
        String nomeFilme = scanner.nextLine();
        ArrayList<Filme> filmes = filmeNegocio.buscarFilmePorNome(nomeFilme);

        if (filmes.isEmpty()) {
            System.out.println("Filme não encontrado.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.println("Nome: " + filme.getNomeFilme());
            System.out.println("Data de lançamento: " + filme.getDataLancamento());
            System.out.println("Orçamento: " + filme.getOrcamento());
            System.out.println("Descrição: " + filme.getDescricao());
            System.out.println("Gênero: " + filme.getGenero());

            Diretor diretor = filme.getDiretor();
            if (diretor != null) {
                System.out.println("Diretor: " + diretor.getNome());
            } else {
                System.out.println("Diretor: Não associado");
            }

            System.out.println("Atores: ");
            for (Ator ator : filme.getAtores()) {
                System.out.println(ator.getNome());
            }
        }
    }
}
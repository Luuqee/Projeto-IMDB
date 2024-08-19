package tech.ada.imdb.negocio;

import tech.ada.imdb.model.Diretor;
import tech.ada.imdb.persistencia.DiretorBancoDeDados;

import java.util.ArrayList;

public class DiretorNegocio {

    private final DiretorBancoDeDados bancoDeDados;

    public DiretorNegocio(DiretorBancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void salvar(Diretor diretor) {
        if (diretor.getNome() != null && !diretor.getNome().isBlank()) {
            bancoDeDados.salvarDiretor(diretor);
        }
    }

    public ArrayList<Diretor> encontrarDiretorPorNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            return bancoDeDados.findDiretorByName(nome);
        }
        throw new IllegalArgumentException("Parâmetro nome deve ser preenchido");
    }

    public ArrayList<Diretor> obterDiretor() {
        ArrayList<Diretor> diretoresSalvos = bancoDeDados.getDiretores();

        for(Diretor diretor : diretoresSalvos) {
            System.out.println("Nome: " + diretor.getNome());
        }

        return diretoresSalvos;
    }
}

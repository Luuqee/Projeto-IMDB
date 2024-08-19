package tech.ada.imdb.persistencia;

import tech.ada.imdb.model.Ator;

import java.util.ArrayList;

public class AtorBancoDeDados {

    private ArrayList<Ator> atores = new ArrayList<Ator>();


    public void salvarAtor(Ator ator) {
        atores.add(ator);
    }

    public ArrayList<Ator> buscarAtorPorNome(String nome) {
        ArrayList<Ator> atoresEncontrados = new ArrayList<>();

        for(Ator ator : atores) {

            if (ator.getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                atoresEncontrados.add(ator);
            }
        }
        return atoresEncontrados;
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }
}

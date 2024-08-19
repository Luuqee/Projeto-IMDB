package tech.ada.imdb.negocio;

import tech.ada.imdb.model.Ator;
import tech.ada.imdb.persistencia.AtorBancoDeDados;

import java.util.ArrayList;

public class AtorNegocio {

    private AtorBancoDeDados bancoDeDados;

    public AtorNegocio(AtorBancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }

    public void salvar(Ator ator) {
        if (ator.getNome() != null && !ator.getNome().isBlank()) {
            bancoDeDados.salvarAtor(ator);
        }
    }

    public ArrayList<Ator> findAtoresByName(String nome){
        ArrayList<Ator> atoresEncontrados = new ArrayList<>();
        ArrayList<Ator> atoresSalvos = bancoDeDados.getAtores();

        for(Ator ator : atoresSalvos) {
            if (ator.getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                atoresEncontrados.add(ator);
            }
        }

        return atoresSalvos;
    }


}

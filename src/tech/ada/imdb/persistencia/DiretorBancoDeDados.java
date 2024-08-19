package tech.ada.imdb.persistencia;

import tech.ada.imdb.model.Diretor;

import java.util.ArrayList;

public class DiretorBancoDeDados {

    ArrayList<Diretor> diretores = new ArrayList<Diretor>();


    public void salvarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public ArrayList<Diretor> findDiretorByName(String nome) {
        ArrayList<Diretor> diretoresEncontrados = new ArrayList<>();

        for(Diretor diretor : diretores) {

            if (diretor.getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                diretoresEncontrados.add(diretor);
            }
        }
        return diretoresEncontrados;
    }

    public ArrayList<Diretor> getDiretores() {
        return diretores;
    }
}

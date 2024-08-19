package tech.ada.imdb.persistencia;

import tech.ada.imdb.model.Filme;

import java.util.ArrayList;

public class FilmeBancoDeDados {

    private ArrayList<Filme> filmes = new ArrayList<Filme>();

    public void salvarFilme(Filme filme) {
        filmes.add(filme);
    }

    public ArrayList<Filme> buscarFilmePorNome(String nome) {
        ArrayList<Filme> filmesEncontrados = new ArrayList<>();

        for(Filme filme : filmes) {

            if (filme.getNomeFilme().toLowerCase().startsWith(nome.toLowerCase())) {
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }
}

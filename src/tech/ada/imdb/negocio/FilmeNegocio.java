package tech.ada.imdb.negocio;

import tech.ada.imdb.model.Filme;
import tech.ada.imdb.persistencia.FilmeBancoDeDados;

import java.util.ArrayList;

public class FilmeNegocio {

    private FilmeBancoDeDados bancoDeDados;

    public FilmeNegocio(FilmeBancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void salvarFilme(Filme filme) {

        if (filme.getNomeFilme() != null && !filme.getNomeFilme().isBlank()) {
            bancoDeDados.salvarFilme(filme);
        }
    }

    public ArrayList<Filme> buscarFilmePorNome(String nome) {
        return bancoDeDados.buscarFilmePorNome(nome);
    }
}

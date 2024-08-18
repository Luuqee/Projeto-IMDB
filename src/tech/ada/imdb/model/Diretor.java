package tech.ada.imdb.model;

import java.util.ArrayList;

public class Diretor extends Pessoa{

    private final ArrayList<Filme> filmes;

    public Diretor(String nome, String dataNascimento, String sexo, ArrayList<Filme> filmes) {
        super(nome, dataNascimento, sexo);
        this.filmes = filmes;
    }


}

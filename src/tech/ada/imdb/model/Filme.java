package tech.ada.imdb.model;

import java.util.ArrayList;

public class Filme {

    private final String nomeFilme;
    private final String dataLancamento;
    private final double orcamento;
    private final String descricao;
    private final Genero genero;
    private final ArrayList<Diretor> diretor;
    private final ArrayList<Ator> atores;





    public Filme(String nomeFilme, String dataLancamento, double orcamento, String descricao, Genero genero, ArrayList<Diretor> diretor) {
        this.nomeFilme = nomeFilme;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.genero = genero;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
    }




    public Genero getGenero() {
        return genero;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }


    public String getDataLancamento() {
        return dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getDescricao() {
        return descricao;
    }


    public ArrayList<Ator> getAtores() {
        return atores;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor.clear();
        this.diretor.add(diretor);
    }

    public Diretor getDiretor() {
        if (diretor.isEmpty()) {
            return null;
        }
        return diretor.getFirst();
    }
}






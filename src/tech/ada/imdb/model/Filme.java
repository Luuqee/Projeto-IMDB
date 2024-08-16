package tech.ada.imdb.model;

public class Filme {

    private String nomeFilme;
    private String dataLancamento;
    private double orcamento;
    private String descricao;

// Construtor


public Filme(String nomeFilme, String dataLancamento, double orcamento, String descricao) {
    this.nomeFilme = nomeFilme;
    this.dataLancamento = dataLancamento;
    this.orcamento = orcamento;
    this.descricao = descricao;

}

// Get e Set

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}




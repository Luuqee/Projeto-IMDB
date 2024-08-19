package tech.ada.imdb.model;


public abstract class Pessoa {
    private String nome;
    private String dataNascimento;
    private String sexo;

    public Pessoa(String nome, String dataNascimento, String sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'';
    }
}

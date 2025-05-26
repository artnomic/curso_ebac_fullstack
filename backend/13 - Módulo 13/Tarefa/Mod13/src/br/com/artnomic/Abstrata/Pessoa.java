package br.com.artnomic.Abstrata;

public abstract class Pessoa {
    private String nome;
    private String natureza;
    private double renda;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public abstract void DeclararImposto ();
}

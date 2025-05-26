package br.com.artnomic.Interfaces;

public interface ICaneta {
    public void escrever(String texto);
    public String getCor();

    default void escreverComum() {
        System.out.println("Todos escrevem assim!");
    }
}

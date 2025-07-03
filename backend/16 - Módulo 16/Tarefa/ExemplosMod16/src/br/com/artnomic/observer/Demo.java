package br.com.artnomic.observer;

public class Demo {
    public static void main(String[] args) {
        Jornalista jor = new Jornalista();
        jor.add(new TV());
        jor.notifyAll("teste");
    }
}

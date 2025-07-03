package br.com.artnomic.templatemethod;

public abstract class Trabalhador {

    public void executarRotina() {
        iniciarRotina();
        levantar();
        irTrabalhar();
        trabalhar();
        voltarParaCasa();
    }

    protected abstract void trabalhar();

    private void voltarParaCasa() {
        System.out.println("Depois de um exaustivo dia de trabaho, voltando para casa!");
    }

    private void irTrabalhar() {
        System.out.println("Indo ao Trabalho");
    }

    private void iniciarRotina() {
        System.out.println("Iniciando a Rotina");
    }

    private void levantar() {
        System.out.println("Levantando da cama");
    }
}

package br.com.artnomic.observer;

public class TV implements Observer{
    @Override
    public void update(Subject subject) {
        System.out.println("Recebendo a notícia via TV!" + subject.toString());
    }
}

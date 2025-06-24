package br.com.artnomic.singleton;

public class DemoSingleton {
    public static void main(String args[]){
        Singleton singleton = Singleton.getInstance();

        System.out.println(singleton);
    }
}

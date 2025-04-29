package br.com.artnomic;

public class Main {
    public static void main(String[] args) {
        String ambiente = args[0];

        if (ambiente.equalsIgnoreCase("DEV")) {
            System.out.println("Hello! You are in " + ambiente + "! Make sure, if Developer is the correct");
        } else if (ambiente.equalsIgnoreCase("STG")) {
            System.out.println("Hello! You are in " + ambiente + "! Make sure, if Stage is the correct");
        } else {
            System.out.println("Hello! You are in " + ambiente + "! Make sure, if Homolog is the correct");
        }

    }
}
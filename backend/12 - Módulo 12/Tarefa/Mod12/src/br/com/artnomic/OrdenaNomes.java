package br.com.artnomic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenaNomes {
    static Scanner scanner = new Scanner(System.in);

    public static void ordenaNome() {
        List<String> nomes = new ArrayList<>();

        System.out.print("Quantos nomes você quer inserir? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o nome #" + (i + 1) + ": ");
            String nome = scanner.nextLine();
            nomes.add(nome);
        }

        Collections.sort(nomes);

        System.out.println("\nNomes em ordem alfabética:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        scanner.close();
    }
}

/**
 * @author arthur.berson
 */
package br.com.artnomic;

import java.util.*;

public class SepararPorSexo {
    static Scanner scanner = new Scanner(System.in);

    public static void separaPorSexo() {
        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o sexo (M/F): ");
            String sexo = scanner.nextLine().toUpperCase();

            if (sexo.equals("M")) {
                masculino.add(nome);
            } else if (sexo.equals("F")) {
                feminino.add(nome);
            } else {
                System.out.println("Sexo inválido! Ignorando...");
            }
        }


        System.out.println("\n--- Masculino ---");
        for (String nome : masculino) {
            System.out.println(nome);
        }

        System.out.println("\n--- Feminino ---");
        for (String nome : feminino) {
            System.out.println(nome);
        }

        scanner.close();
    }
}

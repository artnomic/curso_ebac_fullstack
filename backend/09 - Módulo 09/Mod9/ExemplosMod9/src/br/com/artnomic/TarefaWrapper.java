/**
 * @author arthur.berson
 */
package br.com.artnomic;

import java.util.Scanner;

public class TarefaWrapper {
    public static void tarefaWrapper() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        Integer numeroWrapper = numero;

        Long numeroCasting = (long) numeroWrapper;

        System.out.println("Você digitou o número: " + numero);
        System.out.println("Você digitou (com Wrapper): " + numeroWrapper);
        System.out.println("Você digitou (com Casting): " + numeroCasting);

        scanner.close();
    }
}

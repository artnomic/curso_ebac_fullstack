/**
 * @author arthur.berson
 */
package br.com.artnomic;

import java.util.Scanner;

public class TarefaCalculoMedia {

    static Scanner scanner = new Scanner(System.in);


    public static void tarefaCalculoMedia() {
        System.out.println("|---- CALCULADORA DE MÉDIA ----|");

        System.out.println("\nDigite a NOTA 1: ");
        double nota1 = validaInput();

        System.out.println("\nDigite a NOTA 2: ");
        double nota2 = validaInput();

        System.out.println("\nDigite a NOTA 3: ");
        double nota3 = validaInput();

        System.out.println("\nDigite a NOTA 4: ");
        double nota4 = validaInput();


        System.out.println("\n\n|--- CALCULANDO A MÉDIA ---|");
        calculaMedia(nota1, nota2, nota3, nota4);

        scanner.close();
    }

    public static double validaInput() {
        Scanner scanner = new Scanner(System.in);

        double nota = scanner.nextDouble();

        if (nota < 0 || nota > 10 ) {
            System.out.println("Valor incorreto, digite um número entre 0 e 10: ");
            return validaInput();
        } else {
            System.out.println("Sua NOTA nessa prova foi: " + nota);
            return nota;
        }
    }

    public static void calculaMedia(double nota1, double nota2, double nota3, double nota4) {
        double media = (nota1 + nota2 + nota3 + nota4)/4;

        if (media <= 4 ) {
            System.out.println("Que pena, sua média não foi suficiente para ser aprovado! Você está REPROVADO! \nMÉDIA FINAL: " + media);
        } else if (media >= 7) {
            System.out.println("Parabéns, sua média foi perfeita para ser aprovado! \nMÉDIA FINAL: " + media);
        } else {
            System.out.println("Que pena, sua média não foi suficiente para ser aprovado! Mas você está de RECUPERAÇÃO! \nMÉDIA FINAL: " + media);
        }
    }
}

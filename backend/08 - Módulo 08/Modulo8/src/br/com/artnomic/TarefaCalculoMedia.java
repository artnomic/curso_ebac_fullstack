/**
 * @author arthur.berson
 */
package br.com.artnomic;

import java.util.Scanner;

public class TarefaCalculoMedia {
    public static void tarefaCalculoMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("|---- CALCULADORA DE MÉDIA ----|");

        //Digite a nota de número 1:
        System.out.println("Digite a NOTA 1: ");

        long num1 = -1;
        num1 = scanner.nextLong();

        if (num1 < 0 || num1 > 10 ) {
            System.out.println("Valor incorreto, digite um número entre 0 e 10 ");
            num1 = scanner.nextLong();
        } else {
            System.out.println("Sua NOTA 1 foi: " + num1);
        }

        //Digite a nota de número 2:
        System.out.println("Digite a NOTA 2: ");

        long num2 = -1;
        num2 = scanner.nextLong();

        if (num2 < 0 || num2 > 10 ) {
            System.out.println("Valor incorreto, digite um número entre 0 e 10 ");
            num2 = scanner.nextLong();
        } else {
            System.out.println("Sua NOTA 2 foi: " + num2);
        }

        //Digite a nota de número 3:
        System.out.println("Digite a NOTA 3: ");

        long num3 = -1;
        num3 = scanner.nextLong();

        if (num3 < 0 || num3 > 10 ) {
            System.out.println("Valor incorreto, digite um número entre 0 e 10 ");
            num3 = scanner.nextLong();
        } else {
            System.out.println("Sua NOTA 3 foi: " + num3);
        }

        //Digite a nota número 4:
        System.out.println("Digite a NOTA 4: ");

        long num4 = -1;
        num4 = scanner.nextLong();

        if (num4 < 0 || num4 > 10 ) {
            System.out.println("Valor incorreto, digite um número entre 0 e 10 ");
            num4 = scanner.nextLong();
        } else {
            System.out.println("Sua NOTA 2 foi: " + num4);
        }

        scanner.close();


        //Calculo de média:
        System.out.println("|--- CALCULANDO A MÉDIA ---|");
        long media = (num1 + num2 + num3 + num4) / 4;

        if (media < 5 ) {
            System.out.println("Que pena, sua média não foi suficiente para ser aprovado! MÉDIA FINAL: " + media);
        } else if (media > 6) {
            System.out.println("Parabéns, sua média foi perfeita para ser aprovado! MÉDIA FINAL: " + media);
        } else {
            System.out.println("Que pena, sua média não foi suficiente para ser aprovado! Mas você está de recuperação! MÉDIA FINAL: " + media);
        }
    }
}

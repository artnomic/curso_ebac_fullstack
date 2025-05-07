/**
 * @author arthur.berson
 */
package br.com.artnomic;

public class OperadoresAritmeticos {
    public static void operacoesAritmeticas() {
        int num1 = 10;
        int num2 = 20;

        int num3 = num1 + num2;
        int num4 = num1 - num2;
        int num5 = num1 / num2;
        int num6 = num1 * num2;

        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
    }

    public static void operacoesAtribuicoes() {
        int num1 = 10;
        int num2 = 10;
        int num3 = num1 + num2;
        num3 += num3;
    }

    public static void operacoesIncrementoDecremento() {
        int num1 = 10;
        num1++;
        num1--;
    }

    public static void operacoesRelacionais() {
        int num1 = 10;
        int num2 = 20;

        boolean verdadeiroOuFalso = num1 == num2;
        verdadeiroOuFalso = num1 > num2;
        verdadeiroOuFalso = num1 >= num2;
        verdadeiroOuFalso = num1 <= num2;
        verdadeiroOuFalso = num1 < num2;
        verdadeiroOuFalso = num1 != num2;
    }

    public static void operacoesLogicas() {
        int num1 = 10;
        int num2 = 10;


    }
}

package br.com.artnomic.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SepararPorSexo {

    public void executar() {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Pessoa> todasAsPessoas = coletarDados(scanner);

            List<Pessoa> mulheres = filtrarMulheres(todasAsPessoas);

            imprimirResultado(mulheres);

        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private List<Pessoa> coletarDados(Scanner scanner) {
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Cadastro da Pessoa " + (i + 1) + " ---");
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o sexo (M/F): ");
            String sexo = scanner.nextLine().toUpperCase();

            pessoas.add(new Pessoa(nome, sexo));
        }
        return pessoas;
    }

    private List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        System.out.println("\nProcessando e filtrando a lista...");
        return pessoas.stream()
                .filter(pessoa -> pessoa.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());
    }

    private void imprimirResultado(List<Pessoa> mulheres) {
        System.out.println("\n--- Lista de Mulheres ---");
        if (mulheres.isEmpty()) {
            System.out.println("Nenhuma mulher foi cadastrada.");
        } else {
            mulheres.forEach(mulher -> System.out.println(mulher.getNome()));
        }
    }
}
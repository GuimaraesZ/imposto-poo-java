package com.exercicio.Controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.exercicio.model.Pessoa;
import com.exercicio.model.PessoaFisica;
import com.exercicio.model.PessoaJuridica;

public class PessoaController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);

        List<Pessoa> pessoas = new ArrayList<>();
        int n = 0;
        while (true) {
            System.out.println("Enter the number of tax payers: ");
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a number greater than zero.");
                    continue;
                }
                sc.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer for the number of tax payers.");
                sc.nextLine();
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Tax payer #" + (i + 1) + " data:");
            char tipo;
            while (true) {
                System.out.print("Individual or company (i/c)? ");
                String tipoStr = sc.nextLine().trim().toLowerCase();
                if (tipoStr.equals("i") || tipoStr.equals("c")) {
                    tipo = tipoStr.charAt(0);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'i' for individual or 'c' for company.");
                }
            }

            System.out.print("Name: ");
            String nome = sc.nextLine();

            double rendaAnual = 0.0;
            while (true) {
                System.out.print("Anual income: ");
                try {
                    rendaAnual = sc.nextDouble();
                    if (rendaAnual < 0) {
                        System.out.println("Income cannot be negative. Try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for income.");
                    sc.nextLine();
                }
            }

            if (tipo == 'i') {
                double gastoSaude = 0.0;
                while (true) {
                    System.out.print("Health expenditures: ");
                    try {
                        gastoSaude = sc.nextDouble();
                        if (gastoSaude < 0) {
                            System.out.println("Health expenditures cannot be negative. Try again.");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number for health expenditures.");
                        sc.nextLine();
                    }
                }
                pessoas.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
            } else {
                int numeroFuncionarios = 0;
                while (true) {
                    System.out.print("Number of employees: ");
                    try {
                        numeroFuncionarios = sc.nextInt();
                        if (numeroFuncionarios < 0) {
                            System.out.println("Number of employees cannot be negative. Try again.");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for number of employees.");
                        sc.nextLine();
                    }
                }
                pessoas.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
            sc.nextLine(); 
        }

        sc.close();

        System.out.println();
        System.out.println("TAXES PAID:");
        double totalTaxes = 0.0;
        for (Pessoa pessoa : pessoas) {
            String nome = pessoa.getNome();
            double imposto = pessoa.imposto();
            System.out.printf("%s: $ %.2f\n", nome, imposto);
            totalTaxes += imposto;
        }
        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f\n", totalTaxes);
    }
}

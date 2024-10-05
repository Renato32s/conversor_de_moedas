package com.br.conversor.modulos.ui;

import com.br.conversor.modulos.controller.AllClear;
import com.br.conversor.modulos.controller.ApiSave;
import com.br.conversor.modulos.controller.Conection;
import com.br.conversor.modulos.controller.ExtraOptions;

import java.util.Scanner;

import static com.br.conversor.modulos.controller.AllClear.centraliza;
import static com.br.conversor.modulos.controller.ApiSave.solicitarApiKeyAoUsuario;

public class InterfaceUi {
    public static void inicio() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*************************************\n");
        System.out.println("Bem vindo ao conversor de moedas");
        String apiKey = ApiSave.recuperarApiKey();
        if (apiKey == null) {
            apiKey = solicitarApiKeyAoUsuario(scanner);
            ApiSave.salvarApiKey(apiKey);
        }
        int options;
        System.out.print("""
                1) Real -> Dólar
                2) Real -> Peso argentino
                3) Real -> Euro
                4) Dólar -> Real
                5) Peso argentino -> Real
                6) Euro -> Real
                7) Outras opções
                0) Sair
                
                Escolha uma das opções:
                """);
        options = scanner.nextInt();
        do {
            switch (options) {
                case 1:
                    try {
                        Double currency = Conection.convert(apiKey, "BRl", "USD");
                        System.out.print("Digite o valor que deseja converter: ");
                        scanner.nextLine();
                        String moedaString = scanner.nextLine().replace(",", ".");

                        Double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de R$ %.2f convertido é: $ %.2f", moeda, (moeda * currency));

                        System.out.println();
                        centraliza("************************************ ");
                        centraliza(texto);
                        centraliza("press enter para retornar");
                        centraliza("************************************ ");
                        scanner.nextLine();
                        AllClear.clear();
                        InterfaceUi.inicio();
                    } catch (NumberFormatException e) {
                        System.out.println("o valor digitado está incorreto.");
                    }
                    break;
                case 2:
                    try {
                        Double currency = Conection.convert(apiKey, "BRL", "ARS");
                        System.out.print("Digite o valor que deseja converter: ");
                        scanner.nextLine();
                        String moedaString = scanner.nextLine().replace(",", ".");

                        Double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de R$ %.2f convertido é: $ %.2f", moeda, (moeda * currency));

                        System.out.println();
                        centraliza("************************************ ");
                        centraliza(texto);
                        centraliza("press enter para retornar");
                        centraliza("************************************ ");
                        scanner.nextLine();
                        AllClear.clear();
                        InterfaceUi.inicio();
                    } catch (NumberFormatException e) {
                        System.out.println("o valor digitado está incorreto.");
                    }
                    break;
                case 3:
                    try {
                        Double currency = Conection.convert(apiKey, "BRL", "EUR");
                        System.out.print("Digite o valor que deseja converter: ");
                        scanner.nextLine();
                        String moedaString = scanner.nextLine().replace(",", ".");

                        Double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de R$ %.2f convertido é: € %.2f", moeda, (moeda * currency));

                        System.out.println();
                        centraliza("************************************ ");
                        centraliza(texto);
                        centraliza("press enter para retornar");
                        centraliza("************************************ ");
                        scanner.nextLine();
                        AllClear.clear();
                        InterfaceUi.inicio();
                    } catch (NumberFormatException e) {
                        System.out.println("o valor digitado está incorreto.");
                    }
                    break;
                case 4:
                    try {
                        Double currency = Conection.convert(apiKey, "USD", "BRL");
                        System.out.print("Digite o valor que deseja converter: ");
                        scanner.nextLine();
                        String moedaString = scanner.nextLine().replace(",", ".");

                        Double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de $ %.2f convertido é: R$ %.2f", moeda, (moeda * currency));

                        System.out.println();
                        centraliza("************************************ ");
                        centraliza(texto);
                        centraliza("press enter para retornar");
                        centraliza("************************************ ");
                        scanner.nextLine();
                        AllClear.clear();
                        InterfaceUi.inicio();
                    } catch (NumberFormatException e) {
                        System.out.println("o valor digitado está incorreto.");
                    }
                    break;
                case 5:
                    try {
                        Double currency = Conection.convert(apiKey, "ARS", "BRL");
                        System.out.print("Digite o valor que deseja converter: ");
                        scanner.nextLine();
                        String moedaString = scanner.nextLine().replace(",", ".");

                        Double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de $ %.2f convertido é: R$ %.2f", moeda, (moeda * currency));

                        System.out.println();
                        centraliza("************************************ ");
                        centraliza(texto);
                        centraliza("press enter para retornar");
                        centraliza("************************************ ");
                        scanner.nextLine();
                        AllClear.clear();
                        InterfaceUi.inicio();
                    } catch (NumberFormatException e) {
                        System.out.println("o valor digitado está incorreto.");
                    }
                    break;
                case 6:
                    try {
                        Double currency = Conection.convert(apiKey, "EUR", "BRL");
                        System.out.print("Digite o valor que deseja converter: ");
                        scanner.nextLine();
                        String moedaString = scanner.nextLine().replace(",", ".");

                        Double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de € %.2f convertido é: R$ %.2f", moeda, (moeda * currency));

                        System.out.println();
                        centraliza("************************************ ");
                        centraliza(texto);
                        centraliza("press enter para retornar");
                        centraliza("************************************ ");
                        scanner.nextLine();
                        AllClear.clear();
                        InterfaceUi.inicio();
                    } catch (NumberFormatException e) {
                        System.out.println("o valor digitado está incorreto.");
                    }
                    break;
                case 7:
                    ExtraOptions.exibeOutras();
                    break;
                case 0:
                    System.out.println("saindo....");
                    options = -1;
                    break;
                default:
                    System.out.println("opção invalida tente novamente");
                    InterfaceUi.inicio();
                    break;

            }
        } while (options == 0);

        }
        public static void exibeOutras() {
            System.out.println("\n*** outras opções ***\n");
            exibeOutras();
        }
}

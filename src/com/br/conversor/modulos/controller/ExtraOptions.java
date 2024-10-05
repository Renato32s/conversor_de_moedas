package com.br.conversor.modulos.controller;

import com.br.conversor.modulos.ui.InterfaceUi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import static com.br.conversor.modulos.controller.AllClear.centraliza;

public class ExtraOptions {
    public static void exibeOutras() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String apiKey = ApiSave.recuperarApiKey();
        String api;
        AllClear.clear();
        centraliza("************************************ ");
        centraliza("as 60 principais moedas");
        centraliza("************************************ \n");

        HashMap<String, String> currencies = new HashMap<>();
        currencies.put("BRL", "Real Brasileiro");
        currencies.put("USD", "Dólar dos Estados Unidos");
        currencies.put("EUR", "Euro");
        currencies.put("JPY", "Iene japonês");
        currencies.put("GBP", "Libra esterlina britânica");
        currencies.put("AUD", "Dólar australiano");
        currencies.put("CAD", "Dólar canadense");
        currencies.put("CHF", "Franco suíço");
        currencies.put("CNY", "Yuan chinês");
        currencies.put("SEK", "Coroa sueca");
        currencies.put("NZD", "Dólar neozelandês");
        currencies.put("KRW", "Won sul-coreano");
        currencies.put("SGD", "Dólar de Singapura");
        currencies.put("NOK", "Coroa norueguesa");
        currencies.put("MXN", "Peso mexicano");
        currencies.put("INR", "Rupia indiana");
        currencies.put("RUB", "Rublo russo");
        currencies.put("ZAR", "Rand sul-africano");
        currencies.put("HKD", "Dólar de Hong Kong");
        currencies.put("TRY", "Lira turca");
        currencies.put("IDR", "Rupia indonésia");
        currencies.put("MYR", "Ringgit malaio");
        currencies.put("PLN", "Zloty polonês");
        currencies.put("COP", "Peso colombiano");
        currencies.put("THB", "Baht tailandês");
        currencies.put("CLP", "Peso chileno");
        currencies.put("PHP", "Peso filipino");
        currencies.put("EGP", "Libra egípcia");
        currencies.put("CZK", "Coroa checa");
        currencies.put("AFN", "Afegane afegão");
        currencies.put("ALL", "Lek albanês");
        currencies.put("AMD", "Dram armênio");
        currencies.put("ANG", "Florim das Antilhas Holandesas");
        currencies.put("AOA", "Kwanza angolano");
        currencies.put("ARS", "Peso argentino");
        currencies.put("AWG", "Florim de Aruba");
        currencies.put("AZN", "Manat azerbaijano");
        currencies.put("BBD", "Dólar de Barbados");
        currencies.put("BDT", "Taka bengalesa");
        currencies.put("BGN", "Lev búlgaro");
        currencies.put("BHD", "Dinar bareinita");
        currencies.put("BIF", "Franco burundiano");
        currencies.put("BMD", "Dólar das Bermudas");
        currencies.put("BND", "Dólar de Brunei");
        currencies.put("BOB", "Boliviano boliviano");
        currencies.put("BSD", "Dólar das Bahamas");
        currencies.put("BTN", "Ngultrum butanês");
        currencies.put("BWP", "Pula de Botsuana");
        currencies.put("BYN", "Rublo bielorrusso");
        currencies.put("BZD", "Dólar do Belize");
        currencies.put("CDF", "Franco congolês");
        currencies.put("DOP", "Peso dominicano");
        currencies.put("DZD", "Dinar argelino");
        currencies.put("ERN", "Nakfa eritreia");
        currencies.put("ETB", "Birr etíope");
        currencies.put("FJD", "Dólar fijiano");
        currencies.put("FKP", "Libra das Ilhas Falkland");
        currencies.put("GGP", "Libra de Guernsey");
        currencies.put("GEL", "Lari georgiano");
        currencies.put("GHS", "Cedi ganês");
        currencies.put("GIP", "Libra de Gibraltar");
        currencies.put("GMD", "Dalasi gambiano");
        currencies.put("GNF", "Franco guineense");
        currencies.put("GTQ", "Quetzal guatemalteco");
        currencies.put("GYD", "Dólar da Guiana");
        int count = 0;
        for (String code : currencies.keySet()) {
            System.out.printf("%-5s: %-40s", code, currencies.get(code));
            count++;
            if (count % 2 == 0) {
                System.out.println();
                Thread.sleep(200);
            }
        }
        System.out.println();

        try {
            System.out.println("press enter para continuar...");
            scanner.nextLine();
            System.out.print("Qual a moeda de origem? (exemplo BRL): ");
            String moedaOrig = scanner.nextLine().toUpperCase();

            System.out.print("Qual a moeda de destino? (exemplo USD): ");
            String moedaDest = scanner.nextLine().toUpperCase();

            Double currency = Conection.convert(apiKey, moedaOrig, moedaDest);
            System.out.print("Qula o valor que deseja converter?: ");

            String moedaString = scanner.nextLine().replace(",", ".");

            Double moeda = Double.parseDouble(moedaString);
            String texto = String.format("O valor de R$ " + moedaOrig + " convertido é: " + (moeda * currency));

            System.out.println();
            centraliza("************************************ ");
            centraliza(texto);
            centraliza("Enter para retornar");
            centraliza("************************************ ");

            scanner.nextLine();
            AllClear.clear();
            InterfaceUi.inicio();
        } catch (NumberFormatException e) {
            System.out.println("Erro: o valor digitado está incorreto.");
        } catch (InterruptedException e) {
            System.out.println("Erro ao acessar o serviço de conversão de moeda.");
            e.printStackTrace();
        }
    }
}
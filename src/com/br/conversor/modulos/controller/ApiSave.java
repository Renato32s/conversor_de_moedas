package com.br.conversor.modulos.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApiSave {
    private static final Map<String, String> cache = new HashMap<>();

    public static void salvarApiKey(String apiKey) {
        cache.put("apiKey", apiKey);
    }

    public static String recuperarApiKey() {
        return cache.get("apiKey");
    }

    public static String solicitarApiKeyAoUsuario(Scanner scanner) {
        System.out.print("Digite sua api-key: ");
        return scanner.nextLine();
    }
}


package com.br.conversor.modulos.controller;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conection {
    public static Double convert(String apiKey, String moedaOrig, String moedaDest) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaOrig + "/" + moedaDest))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                String json = response.body();;
                Moeda retorno = gson.fromJson(json, Moeda.class);
                return retorno.conversion_rate();
            } else {
                System.err.println("erro ao obter a txa de câmbio. código de status: " + response.statusCode());
                return null;
            }
        } catch (IOException e) {
            System.err.println("erro de E/S ao conectar à api: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            System.err.println("thread interrompida durante a conexão à api: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("erro inespeado: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}

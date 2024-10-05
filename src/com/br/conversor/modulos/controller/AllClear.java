package com.br.conversor.modulos.controller;

public class AllClear {
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public static void centraliza(String texto) {
        int largura = 80;
        int espaco = (largura - texto.length()) / 2;
        String espacos = " ".repeat(espaco);
        System.out.println(espacos + texto);
    }
}

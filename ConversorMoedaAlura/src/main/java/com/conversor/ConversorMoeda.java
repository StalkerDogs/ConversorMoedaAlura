package com.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoeda {
    private static final String API_KEY = "e3527768533b60f9a71a70b2";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();
    private static JsonObject rates;

    public static void main(String[] args) {
        try {
            carregarTaxas();
            menuPrincipal();
        } catch (Exception e) {
            System.out.println("Erro ao executar o programa: " + e.getMessage());
        }
    }

    private static void carregarTaxas() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + API_KEY + "/latest/USD"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
        rates = jsonResponse.getAsJsonObject("conversion_rates");
    }

    private static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1 - USD para BRL");
            System.out.println("2 - BRL para USD");
            System.out.println("3 - USD para ARS");
            System.out.println("4 - ARS para USD");
            System.out.println("5 - USD para CLP");
            System.out.println("6 - CLP para USD");
            System.out.println("7 - USD para COP");
            System.out.println("8 - COP para USD");
            System.out.println("9 - USD para BOB");
            System.out.println("10 - BOB para USD");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                continuar = false;
                continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            double resultado = 0;
            switch (opcao) {
                case 1:
                    resultado = converter(valor, "USD", "BRL");
                    System.out.printf("USD %.2f = BRL %.2f%n", valor, resultado);
                    break;
                case 2:
                    resultado = converter(valor, "BRL", "USD");
                    System.out.printf("BRL %.2f = USD %.2f%n", valor, resultado);
                    break;
                case 3:
                    resultado = converter(valor, "USD", "ARS");
                    System.out.printf("USD %.2f = ARS %.2f%n", valor, resultado);
                    break;
                case 4:
                    resultado = converter(valor, "ARS", "USD");
                    System.out.printf("ARS %.2f = USD %.2f%n", valor, resultado);
                    break;
                case 5:
                    resultado = converter(valor, "USD", "CLP");
                    System.out.printf("USD %.2f = CLP %.2f%n", valor, resultado);
                    break;
                case 6:
                    resultado = converter(valor, "CLP", "USD");
                    System.out.printf("CLP %.2f = USD %.2f%n", valor, resultado);
                    break;
                case 7:
                    resultado = converter(valor, "USD", "COP");
                    System.out.printf("USD %.2f = COP %.2f%n", valor, resultado);
                    break;
                case 8:
                    resultado = converter(valor, "COP", "USD");
                    System.out.printf("COP %.2f = USD %.2f%n", valor, resultado);
                    break;
                case 9:
                    resultado = converter(valor, "USD", "BOB");
                    System.out.printf("USD %.2f = BOB %.2f%n", valor, resultado);
                    break;
                case 10:
                    resultado = converter(valor, "BOB", "USD");
                    System.out.printf("BOB %.2f = USD %.2f%n", valor, resultado);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static double converter(double valor, String moedaOrigem, String moedaDestino) {
        double taxaOrigem = rates.get(moedaOrigem).getAsDouble();
        double taxaDestino = rates.get(moedaDestino).getAsDouble();
        
        
        double valorEmUSD = valor / taxaOrigem;
        return valorEmUSD * taxaDestino;
    }
} 
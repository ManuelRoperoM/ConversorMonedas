package com.alura.conversor.api;

import com.alura.conversor.conversion.Conversion;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApi {
    //Api Key = 22a648c4902c5e9d442abd42
    //Example API = https://v6.exchangerate-api.com/v6/22a648c4902c5e9d442abd42/latest/USD
    private String url = "https://v6.exchangerate-api.com/v6/22a648c4902c5e9d442abd42/pair/";

    //Metodo hacer tasa de cambio
    public Conversion changeMoney(String base, String cambio, double amount) throws IOException, InterruptedException {
        url = url + base + '/' + cambio + '/' + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();
        HttpResponse<String> response = client
                                            .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), Conversion.class);
    }
}

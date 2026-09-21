package br.com.spring.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    //busca dados de uma API externa, faz uma requisição HTTP para o endereço fornecido e retorna a resposta como uma string
    public String obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse <String> response = null;
        try{
            response = client.
                    send(request, HttpResponse.BodyHandlers.ofString()); //envia a requisição e obtém a resposta como uma string
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}

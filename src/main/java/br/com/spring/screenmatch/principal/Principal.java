package br.com.spring.screenmatch.principal;

import br.com.spring.screenmatch.component.OmbConfig;
import br.com.spring.screenmatch.model.DadosSerie;
import br.com.spring.screenmatch.service.ConsumoApi;
import br.com.spring.screenmatch.service.ConverteDados;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final OmbConfig ombConfig;
    
    public Principal(OmbConfig ombConfig) {
        this.ombConfig = ombConfig;
    }

    public void exibeMenu(){
        System.out.println("Digite o nome da série que deseja buscar: ");
        var nomeSerie = leitura.nextLine();
        var endereco = ombConfig.API_URL().endsWith("?t=") ? ombConfig.API_URL() : ombConfig.API_URL() + "?t=";
        var apiKey = ombConfig.API_KEY().startsWith("&apikey=") ? ombConfig.API_KEY() : "&apikey=" + ombConfig.API_KEY();
        var json = consumoApi.obterDados(endereco + nomeSerie.replace(" ", "+") + apiKey);
        DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

    }
}

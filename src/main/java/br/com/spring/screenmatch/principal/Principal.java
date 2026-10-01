package br.com.spring.screenmatch.principal;

import br.com.spring.screenmatch.component.OmbConfig;
import br.com.spring.screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final OmbConfig ombConfig;
    
    public Principal(OmbConfig ombConfig) {
        this.ombConfig = ombConfig;
    }

    public void exibeMenu(){
        System.out.println("Digite o nome da série que deseja buscar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ombConfig.API_URL() + nomeSerie.replace(" ", "+") + ombConfig.API_KEY());
    }
}

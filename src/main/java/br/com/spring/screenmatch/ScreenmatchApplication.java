package br.com.spring.screenmatch;

import br.com.spring.screenmatch.model.DadosEpisodios;
import br.com.spring.screenmatch.model.DadosSerie;
import br.com.spring.screenmatch.model.DadosTemporadas;
import br.com.spring.screenmatch.service.ConsumoApi;
import br.com.spring.screenmatch.service.ConverteDados;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
// permite que a classe seja executada como uma aplicação Spring Boot com interface
public class ScreenmatchApplication implements CommandLineRunner {//tarefa a ser executada pós inicialização da aplicação

	@Value("${omdb.api.url}")
	private String omdbApiUrl;

	@Value("${omdb.api.key}")
	private String omdbApiKey;

 //metodo run é chamado quando a aplicação é iniciada, permitindo executar código adicional após o contexto do Spring ser carregado
	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(omdbApiUrl + "?t=gilmore+girls&apikey=" + omdbApiKey);
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);
		var jsonEpisodios = consumoApi.obterDados(omdbApiUrl+"?t=gilmore+girls&Season=1&Episode=1&apikey=" + omdbApiKey);
		DadosEpisodios dadosepisodios = conversor.obterDados(jsonEpisodios, DadosEpisodios.class);
		System.out.println(dadosepisodios);

		List<DadosTemporadas> temporadasList = new ArrayList<>();
		for (int i = 0; i<= dadosSerie.temporadas(); i++) {
			var jsonTemporadas = consumoApi.obterDados(omdbApiUrl+"?t=gilmore+girls&Season="+(i+1)+"&apikey=" + omdbApiKey);
			DadosTemporadas dadosTemporadas = conversor.obterDados(jsonTemporadas, DadosTemporadas.class);
			temporadasList.add(dadosTemporadas);
		}
		temporadasList.forEach(System.out::println); //printa cada elemento da lista de temporadas usando referência de método para System.out.println
	}

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}
}

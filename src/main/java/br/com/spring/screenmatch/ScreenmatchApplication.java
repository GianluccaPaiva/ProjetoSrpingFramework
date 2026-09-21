package br.com.spring.screenmatch;

import br.com.spring.screenmatch.model.DadosSerie;
import br.com.spring.screenmatch.service.ConsumoApi;
import br.com.spring.screenmatch.service.ConverteDados;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	}

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}
}

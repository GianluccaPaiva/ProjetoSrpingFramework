package br.com.spring.screenmatch.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias("Title") String titulo,
                             @JsonAlias("Plot") String descricao,
                             @JsonAlias("imdbRating") String avaliacao,
                             @JsonAlias("Episode") Integer episodio,
                             @JsonAlias("Released") String dataLancamento) {
}

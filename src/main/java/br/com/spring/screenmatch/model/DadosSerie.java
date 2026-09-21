package br.com.spring.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//record é uma classe imutável que encapsula os dados de uma série, incluindo título, número de temporadas e avaliação.
//JsonAlias é usado para mapear os nomes dos campos JSON para os nomes dos parâmetros do record, permitindo que o Jackson desserialize corretamente os dados da API.
//JsonProperty é usado para mapear o nome do campo JSON "imdbVotes" para o parâmetro "votos" do record.
/*
@JsonAlias = "Eu aceito esses nomes alternativos quando estou lendo o JSON." (Só para entrada)
@JsonProperty = "Este é o nome oficial que eu uso para este campo, tanto quando estou lendo quanto quando estou escrevendo o JSON." (Para entrada e saída)
 */
@JsonIgnoreProperties(ignoreUnknown = true) //ignora propriedades desconhecidas durante a desserialização, evitando erros se a API retornar campos adicionais que não estão presentes no record
public record DadosSerie(@JsonAlias({"Title","Titulo"}) String titulo,
                         @JsonAlias("totalSeasons") Integer temporadas,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonProperty("imdbVotes") String votos) {

}
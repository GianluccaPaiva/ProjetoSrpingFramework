package br.com.spring.screenmatch.service;

import br.com.spring.screenmatch.model.DadosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//conversão genérica de dados JSON para objetos Java usando a biblioteca Jackson, implementando a interface IConverteDados
public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDados(String json, Class<T> tipoClasseRetorno) {
        try {
            return mapper.readValue(json, tipoClasseRetorno);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

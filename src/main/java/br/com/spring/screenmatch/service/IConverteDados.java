package br.com.spring.screenmatch.service;

import org.springframework.stereotype.Service;

@Service
public interface IConverteDados {
    //retrorno genérico em obterDados
    <T> T obterDados(String json, Class <T> tipoClasseRetorno);
}

package br.com.spring.screenmatch.service;

public interface IConverteDados {
    //retrorno genérico em obterDados
    <T> T obterDados(String json, Class <T> tipoClasseRetorno);
}

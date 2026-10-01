package br.com.spring.screenmatch.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class OmdBService {
    private final String API_URL;
    private final String API_KEY;

    public OmdBService(@Value("${omdb.api.url}") String API_URL,
                       @Value("${omdb.api.key}") String API_KEY) {
        this.API_URL = API_URL;
        this.API_KEY = API_KEY;
    }
}

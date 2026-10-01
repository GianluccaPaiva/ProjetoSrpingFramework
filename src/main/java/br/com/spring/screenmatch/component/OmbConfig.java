package br.com.spring.screenmatch.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record OmbConfig(
        @Value("${omdb.api.url}") String API_URL,
        @Value("${omdb.api.key}") String API_KEY) {
}

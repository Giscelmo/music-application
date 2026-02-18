package br.com.giscelmo.MusicApplication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.Map;

@Service
public class ConsultaChatGPT {
    private final RestClient restClient;

    public ConsultaChatGPT(OpenAiConfigApi config) {

        this.restClient = RestClient.builder()
                .baseUrl(config.getUrl())
                .defaultHeader("Authorization", "Bearer " + config.getKey())
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String obterInformacaoArtista(String artista) {

        Map<String, Object> body = Map.of(
                "model", "gpt-5.2",
                "input", "Me fale sobre o artista: " + artista
        );

        Map response = restClient.post()
                .uri("/responses")
                .body(body)
                .retrieve()
                .body(Map.class);

        return response.toString();
    }
}

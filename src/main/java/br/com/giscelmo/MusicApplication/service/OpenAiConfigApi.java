package br.com.giscelmo.MusicApplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenAiConfigApi {

    @Value("${openai.api.key}")
    private String key;

    @Value("${openai.api.url}")
    private String url;

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }
}
